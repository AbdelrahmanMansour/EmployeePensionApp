package edu.miu.cs.cs489appsd.model;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee() {
    }

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }


    public boolean isQualifiedForPension() {
        return employmentDate.plusYears(5).isBefore(LocalDate.now()) && pensionPlan == null;
    }

    @Override
    public String toString() {
        return String.format(
                "{ \"employeeId\": %d, \"firstName\": \"%s\", \"lastName\": \"%s\", \"employmentDate\": \"%s\", \"yearlySalary\": %.2f, \"pensionPlan\": %s }",
                employeeId, firstName, lastName, employmentDate, yearlySalary,
                (pensionPlan != null ? pensionPlan.toString() : "null")
        );
    }
}
