package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Set<FileProperty> set = new HashSet<>();
    List<FileProperty> list = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file),
                file.getFileName().toString(), file.toAbsolutePath().toString());
        boolean flag = set.add(fileProperty);
        if (!flag) {
            list.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }

    public Set<FileProperty> getOriginals() {
        return set;
    }

    public List<FileProperty> getDuplicates() {
        return list;
    }
}
