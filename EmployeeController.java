package com.algonquin.cst8288.assignment1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.service.EmployeeService;
import com.algonquin.cst8288.assignment1.service.PersistenceService;

/**
 * Process, validate and save employee data.
 */
public class EmployeeController {

    private List<Employee> employees;//list for the employee objects
    private EmployeeService employeeService;
    private PersistenceService persistenceService;

    /*
    constructor for the lists and services.
    */
    public EmployeeController(EmployeeService employeeService, PersistenceService persistenceService) {
        this.employees = new ArrayList<>();
        this.employeeService = employeeService;
        this.persistenceService = persistenceService;
    }

    /*
    Add an employee to the list.
    */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    
    public String processEmployee(Employee employee) throws IOException {
        // Process data using employee service
        employeeService.calculateTotalCompensation(employee);

        // Debugging statement
        System.out.println("Processing Employee: " + employee);

        // Validate employee data
        if (!isValidEmployee(employee)) {
            
            // Debugging statement
            System.out.println("Validation Failed for Employee: " + employee);
            return "FAILED";
        }

        //Storing data
        persistenceService.saveEmployee(employee, new JSONFormatter(), "employee_data.txt");
        return "SUCCESS";
    }
    /*
    This method is to save the employee data with specified format and with specific filename
    */
    public void saveEmployee(Employee employee, Formatter formatter, String filename) throws IOException {
        persistenceService.saveEmployee(employee, formatter, filename);
    }
    /*
    Print employee data with specific format
    */
    public void printEmployee(Employee employee, Formatter formatter) {
        persistenceService.printEmployee(employee, formatter);
    }
    /*
    Method to get all employees.
    */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Method to validates the Employee object
    private boolean isValidEmployee(Employee employee) {
        /*
        Checking for the name if it is present.
        */
        if (!isPresent(employee.getName())) {
            return false;
        }
        employee.setName(employee.getName().trim());
        /*
        Checking for alphanumeric characters if present
        */
        if (!isValidAlphaNumeric(employee.getName())) {
            return false;
        }
        /*
        Checking if there is a name and validating the e-mail
        */
        if (employee.getEmail() == null || employee.getEmail().trim().length() == 0) {
            return false;
        }
        /*
        Validating the e-mail
        */
        employee.setEmail(employee.getEmail().trim());
        if (!isValidEmail(employee.getEmail())) {
            return false;
        }
        /*
        Checking if salary is positive (Instructions document, Part1.2.a)
        */
        if (!isPositiveInteger(employee.getSalary())) {
            return false;
        }
        /*
        Checking for compensation.
        */
        if (!isNoCompensation(employee.getTotalCompensation())) {
            return false;
        }
        /*
        Checking for service year
        */
        if (!isNoServiceYear(employee.getNumberOfServiceYear())) {
            return false;
        }

        return true;
    }

    // Check for null or empty value
    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }

    // Checking for alphanumeric character
    private boolean isValidAlphaNumeric(String value) {
        String pattern = "^[a-zA-Z0-9 ]+$"; 
        return value.matches(pattern);
    }

    // Checking for valid email
    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailPattern);
    }

    // Checking for positive integer salary
    private boolean isPositiveInteger(double salary) {
        return salary > 0 && (salary == Math.floor(salary));
    }

    // Check for positive total compensation
    private boolean isNoCompensation(double compensation) {
        return compensation >= 0;
    }

    // Check for positive service years
    private boolean isNoServiceYear(int serviceYear) {
        return serviceYear >= 0;
    }
}
