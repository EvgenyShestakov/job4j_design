package ru.job4j.cache;

import java.io.IOException;

public class Emulator {
    public static void main(String[] args) throws IOException {
        DirFileCache dir = new DirFileCache("./");
        String names = dir.get("Names.txt");
        System.out.println(names);
        String address = dir.get("Address.txt");
        System.out.println(address);
    }
}
