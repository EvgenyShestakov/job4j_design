package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineProgrammers implements Report {
    private Store store;

    public ReportEngineProgrammers(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return "<html><head><title>Report</title></head><body>" + text
                + "</body></html>";
    }
}
