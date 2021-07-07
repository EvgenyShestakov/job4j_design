package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    List<Employee> employee;

    public Employees() {

    }

    public Employees(List<Employee> employees) {
        this.employee = employees;
    }
}
