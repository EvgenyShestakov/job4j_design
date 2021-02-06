package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, Integer> map = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        if (!map.containsKey(fileProperty)) {
            map.put(fileProperty, 1);
        } else {
            map.put(fileProperty, (map.get(fileProperty) + 1));
        }
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, Integer> getMap() {
        return map;
    }
}
