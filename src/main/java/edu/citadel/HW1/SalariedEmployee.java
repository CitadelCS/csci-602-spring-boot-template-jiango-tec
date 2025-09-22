package edu.citadel.HW1;

import java.time.LocalDate;
import java.util.Objects;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return annualSalary/12.0;
    }

    @Override
    public String toString() {
        return String.format("%s[name=%s, hireDate=%s, annualSalary=%.1f]",
                getClass().getSimpleName(),
                getName(), getHireDate(), getAnnualSalary()
                );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalariedEmployee that = (SalariedEmployee) o;
        return getName().equals(that.getName())
                && getHireDate().equals(that.getHireDate())
                && Double.compare(that.getAnnualSalary(), getAnnualSalary()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHireDate(), annualSalary);
    }
}
