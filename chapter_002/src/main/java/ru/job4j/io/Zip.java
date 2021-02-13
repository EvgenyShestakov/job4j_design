package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            sources.forEach(file -> {
                try {
                    zip.putNextEntry(new ZipEntry(file.toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            for (Path source : sources) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source.toString()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.
                toString())))) {
            zip.putNextEntry(new ZipEntry(source.toString()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toString()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            List<Path> list = null;
            try {
                list = Search.search(Paths.get(argZip.directory()), argZip.exclude());
            } catch (IOException e) {
                e.printStackTrace();
            }
            zip.packFiles(Objects.requireNonNull(list), Paths.get(argZip.output()));
        }
    }
}
