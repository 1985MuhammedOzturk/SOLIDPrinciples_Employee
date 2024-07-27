package com.algonquin.cst8288.assignment1.employee;

import java.util.Date;

/**
 * Plain Old Java Object (POJO) containing attributes related to employees.
 */
public class Employee {
    private String name;
    private String email;
    private String address;
    private double salary;
    private int numberOfServiceYear;
    private double bonus;
    private double totalCompensation;
    private Date renewalDate;

    /*
    Constructor for creating Employee object
    */
    public Employee(String name, String email, double salary, int numberOfServiceYear) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.numberOfServiceYear = numberOfServiceYear;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNumberOfServiceYear() {
        return numberOfServiceYear;
    }

    public void setNumberOfServiceYear(int numberOfServiceYear) {
        this.numberOfServiceYear = numberOfServiceYear;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    /*
    String representation of the employee object.
    */
    @Override
    public String toString() {
        return "Employee [name=" + name + ", email=" + email + ", address=" + address + ", salary=" + salary
                + ", numberOfServiceYear=" + numberOfServiceYear + ", bonus=" + bonus + ", totalCompensation="
                + totalCompensation + ", renewalDate=" + renewalDate + "]";
    }
}
