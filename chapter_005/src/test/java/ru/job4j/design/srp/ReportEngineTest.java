package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.*;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
    @Test
    public void whenRequiredByTheProgrammerDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineProgrammers(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is("<html><head><title>Report</title></head><body>"
                + expect + "</body></html>"));
    }

    @Test
    public void whenRequiredByTheAccountingDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append("RU").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public  void whenRequiredByHumanResource() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anton", now, now, 120);
        Employee worker3 = new Employee("Irina", now, now, 110);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
                 expect.append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
                 expect.append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
                 assertThat(engine.generate(employee -> true), is(expect.toString()));
    }
}
