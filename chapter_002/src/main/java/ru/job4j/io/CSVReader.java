package ru.job4j.io;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Arguments set incorrectly");
        }
        ArgsName argsName = ArgsName.of(args);
        Path path = Paths.get(argsName.get("path"));
        String out = argsName.get("out");
        PrintStream printStream;
        if (out.equals("stdout")) {
            printStream = System.out;
        } else {
            printStream = new PrintStream(out);
        }
        Set<String> filter = new HashSet<>(Arrays.asList(argsName.get("filter").split(",")));
        String[] columns = null;
        String line;
        int index = 0;
        try (Scanner scanner1 = new Scanner(path)) {
            if (scanner1.hasNext()) {
                columns = scanner1.next().split(",");
            }
            while (scanner1.hasNext()) {
                line = scanner1.next();
                try (Scanner scanner2 = new Scanner(line).useDelimiter(argsName.get("delimiter"))) {
                    while (scanner2.hasNext()) {
                        String step = scanner2.next();
                        if (filter.contains(columns[index])) {
                            System.out.println(step);
                        }
                        index++;
                    }
                    index = 0;
                }
                printStream.println();
            }
        }
        printStream.close();
    }
}
