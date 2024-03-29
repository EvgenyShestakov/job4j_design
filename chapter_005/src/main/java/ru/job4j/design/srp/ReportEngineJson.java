package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineJson implements Report {
    private Store store;

    public ReportEngineJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(list);
    }
}
