package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public void read(Path path, String output, String delimiter, String filter) throws IOException {
        List<List<String>> lists = new ArrayList<>();
        List<Integer> indices;
        try (Scanner scanner1 = new Scanner((path))) {
            indices = parsingIndexes(scanner1.nextLine(), delimiter, filter);
            while (scanner1.hasNext()) {
                String line = scanner1.nextLine();
                try (Scanner scanner2 = new Scanner(line).useDelimiter(delimiter)) {
                    List<String> list = new ArrayList<>();
                    while (scanner2.hasNext()) {
                        list.add(scanner2.next());
                    }
                    lists.add(list);
                }
            }
        }
        if (output.equals("stdout")) {
            outConsole(lists, indices);
        } else {
            outFile(output, lists, indices);
        }
    }

    private List<Integer> parsingIndexes(String heading, String delimiter, String filter) {
        List<Integer> indices = new ArrayList<>();
        String[] filt = filter.split(",");
        String[] headings = heading.split(delimiter);
        for (int i = 0; i < headings.length; i++) {
            for (String f : filt) {
                if (headings[i].equals(f)) {
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }

    private void outFile(String output, List<List<String>> lists, List<Integer> indices) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(output))) {
            for (List<String> list : lists) {
                for (Integer integer : indices) {
                    out.write(list.get(integer));
                    out.newLine();
                }
                out.newLine();
            }
        }
    }

    private void outConsole(List<List<String>> lists, List<Integer> indices) {
        for (List<String> list : lists) {
            for (Integer integer : indices) {
                System.out.println(list.get(integer));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Arguments set incorrectly");
        }
        ArgsName argsName = ArgsName.of(args);
        Path path = Paths.get(argsName.get("path"));
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");
        CSVReader csvReader = new CSVReader();
        csvReader.read(path, out, delimiter, filter);
    }
}