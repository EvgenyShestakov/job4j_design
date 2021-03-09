package ru.job4j.io.filesearch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class SearchFilesByCriterion {
    public void search(String root, String target, SearchFiles searcher) throws IOException {
        Files.walkFileTree(Paths.get(root), searcher);
        List<Path> list = searcher.getPaths();
        try (PrintWriter out = new PrintWriter(target)) {
            for (Path path : list) {
                out.write(path.toString() + System.lineSeparator());
            }
        }
    }

    public static void main(String[]args) throws IOException {
        Args arg = new Args(args);
        SearchFilesByCriterion searchFilesByCriterion = new SearchFilesByCriterion();
        if (arg.valid()) {
            Map<String, String> map = arg.getPair();
            searchFilesByCriterion.search(map.get("-d"), map.get("-o"), arg.getSearcher());
        }
    }
}
