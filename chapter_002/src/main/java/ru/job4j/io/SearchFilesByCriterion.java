package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class SearchFilesByCriterion {
    public void searchName(String root, String target, String name) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.getFileName().toString().equals(name));
        writeLog(root, target, searcher);
    }
    public void searchMask(String root, String target, String mask) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.getFileName().toString().endsWith(mask.substring(1)));
        writeLog(root, target, searcher);
    }

    public void searchRegex(String root, String target, String regex) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.getFileName().toString().matches(regex));
        writeLog(root, target, searcher);
    }

    private void writeLog(String root, String target, SearchFiles searcher) throws IOException {
        Files.walkFileTree(Paths.get(root), searcher);
        List<Path> list = searcher.getPaths();
        try (PrintWriter out = new PrintWriter(target)) {
            for (Path path : list) {
                out.write(path.toString() + System.lineSeparator());
            }
        }
    }

    public static void main(String[]args) throws IOException {
        SearchFilesByCriterion searchFiles = new SearchFilesByCriterion();
        Args arg = new Args(args);
        if (arg.valid()) {
            String type = arg.searchType();
            if (Objects.equals(type, "name")) {
                searchFiles.searchName(arg.directory(), arg.output(), arg.name());
            } else if (Objects.equals(type, "mask")) {
                searchFiles.searchMask(arg.directory(), arg.output(), arg.name());
            } else if (Objects.equals(type, "regex")) {
                searchFiles.searchRegex(arg.directory(), arg.output(), arg.name());
            }
        }
    }
}
