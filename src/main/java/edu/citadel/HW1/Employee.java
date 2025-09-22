package edu.citadel.HW1;

import java.time.LocalDate;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getName() {
        return name;
    }

    public abstract double getMonthlyPay();

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(this.getMonthlyPay(), employee.getMonthlyPay());
    }



}
