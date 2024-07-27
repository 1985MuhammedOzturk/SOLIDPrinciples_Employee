package com.algonquin.cst8288.assignment1.service;

import com.algonquin.cst8288.assignment1.employee.Employee;
import java.util.Date;

/**
 * EmployeeService interface
 */
public interface EmployeeService {
    /**
     * Calculating the total compensation for the given employee.
     * @param employee
     * @return 
     */
    double calculateTotalCompensation(Employee employee);
}
/**
 * Interface Segregation Principle (Part1.2)
 * @author moztu
 */
interface PermanentEmployeeService extends EmployeeService {
    double pensionContribution(Employee employee);
    double calculateBonus(Employee employee);
}

interface ContractEmployeeService extends EmployeeService {
    /**
     * Calculates the renewal date for the employee
     * @param employee
     * @return 
     */
    Date renewalDate(Employee employee);
}
