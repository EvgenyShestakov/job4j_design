package ru.job4j.io.filesearch;

public class SearchFactory {
    public SearchFiles createSearcher(String type, String name) {
        SearchFiles searcher;
        switch (type) {
            case ("name") :
                searcher = new SearchFiles(p -> p.getFileName().toString().equals(name));
                break;
            case ("mask") :
                searcher = new SearchFiles(p -> p.getFileName().toString().endsWith(name.substring(1)));
                break;
            case ("regex") :
                searcher = new SearchFiles(p -> p.getFileName().toString().matches(name));
                break;
            default :
                throw new IllegalArgumentException("Invalid search type:" + type);
        }
        return searcher;
    }
}
