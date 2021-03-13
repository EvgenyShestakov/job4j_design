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
        writeLog(target, list);
    }

    private void writeLog(String target, List<Path> list) throws IOException {
        try (PrintWriter out = new PrintWriter(target)) {
            for (Path path : list) {
                out.println(path);
            }
        }
    }

    public static void main(String[]args) throws IOException {
        Args arg = new Args(args);
        if (arg.valid()) {
            SearchFilesByCriterion searchFilesByCriterion = new SearchFilesByCriterion();
            SearchFactory searchFactory = new SearchFactory();
            Map<String, String> map = arg.getPair();
            SearchFiles searcher = searchFactory.createSearcher(map.get("-t"), map.get("-n"));
            searchFilesByCriterion.search(map.get("-d"), map.get("-o"), searcher);
        }
    }
}
