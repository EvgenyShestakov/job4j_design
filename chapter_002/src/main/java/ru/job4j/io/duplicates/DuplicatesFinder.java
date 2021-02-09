package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("F:\\Документы"), duplicatesVisitor);
        List<FileProperty> fileProperties = duplicatesVisitor.getDuplicates();
        Collections.sort(fileProperties);
        fileProperties.forEach(System.out::println);
    }
}
