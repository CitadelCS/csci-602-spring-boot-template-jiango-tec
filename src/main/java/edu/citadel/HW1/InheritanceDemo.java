package edu.citadel.HW1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee johnD = new HourlyEmployee("John Doe",LocalDate.of(2009,5,21),50.5, 160.0);
        Employee janeD = new HourlyEmployee("Jane Doe", LocalDate.of(2005,9,1),150.5,80.0);

        Employee moeH = new SalariedEmployee("Moe Howard", LocalDate.of(2004,1,1),75000.0);
        Employee curlyH = new SalariedEmployee("Curly Howard", LocalDate.of(2018,1,1),105000.0);

        employees.add(johnD);
        employees.add(janeD);
        employees.add(moeH);
        employees.add(curlyH);

        System.out.println("List of Employees (before sorting):");
        employees.forEach(employee -> System.out.printf("%s\n",employee));

        System.out.println();
        Collections.sort(employees);

        System.out.println("List of Employees (after sorting):");
        employees.forEach(employee -> System.out.printf("%s\n", employee));
        System.out.println();

        double TotalPay = 0.0;
        System.out.println("Monthly Pay:");
        for (Employee employee : employees) {
            TotalPay += employee.getMonthlyPay();
            System.out.printf("%s: $%,.2f\n", employee.getName(), employee.getMonthlyPay());
        }
        System.out.printf("Total Monthly Pay: %,.2f\n", TotalPay);


    }
}
