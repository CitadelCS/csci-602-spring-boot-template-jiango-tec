package edu.citadel.HW1;

import java.time.LocalDate;
import java.util.Objects;

public class HourlyEmployee extends Employee {

    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate, Double wageRate, Double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * hoursWorked;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return Double.compare(wageRate, that.wageRate) == 0
                && Double.compare(hoursWorked, that.hoursWorked) == 0
                && getName().equals(that.getName())
                && getHireDate().equals(that.getHireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getHireDate(),wageRate, hoursWorked);
    }

    @Override
    public String toString() {
        return String.format("%s[name=%s, hireDate=%s, wageRate=%.1f, hoursWorked=%.1f]",
                getClass().getSimpleName(),
                getName(), getHireDate(),
                wageRate, hoursWorked);
    }
}
