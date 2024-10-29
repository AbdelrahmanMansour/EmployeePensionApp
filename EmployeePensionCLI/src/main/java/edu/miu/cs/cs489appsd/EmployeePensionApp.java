package edu.miu.cs.cs489appsd;


import edu.miu.cs.cs489appsd.model.Employee;
import edu.miu.cs.cs489appsd.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EmployeePensionApp {
    private List<Employee> employees;

    public EmployeePensionApp() {
        this.employees = loadEmployees();
    }

    private List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.0)));
        employees.add(new Employee(2, "Benard", "Shaw", LocalDate.of(2019, 4, 3), 197750.0, null));
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75, new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50)));
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2019, 10, 2), 74500.0, null));
        return employees;
    }

    public void printAllEmployees() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearlySalary).reversed())
                .forEach(System.out::println);
    }

    public void printUpcomingEnrollees() {
        LocalDate nextMonthStart = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthEnd = nextMonthStart.plusMonths(1).minusDays(1);

        employees.stream()
                .filter(employee -> employee.isQualifiedForPension() &&
                        employee.getEmploymentDate().plusYears(5).isBefore(nextMonthEnd))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        EmployeePensionApp app = new EmployeePensionApp();
        System.out.println("All Employees:");
        app.printAllEmployees();
        System.out.println("\nUpcoming Enrollees:");
        app.printUpcomingEnrollees();
    }
}