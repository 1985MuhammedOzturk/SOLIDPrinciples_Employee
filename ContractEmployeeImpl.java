package com.algonquin.cst8288.assignment1.service;

import com.algonquin.cst8288.assignment1.employee.Employee;
import java.util.Date;

/**
 * Service implementation for contract employee.
 * @author moztu
 */
public class ContractEmployeeImpl implements ContractEmployeeService {

    /**
     * Calculating the total compensation for contract employee.
     * @param employee
     * @return 
     */
    @Override
    public double calculateTotalCompensation(Employee employee) {
        double totalCompensation = employee.getSalary();
        employee.setTotalCompensation(totalCompensation);
        employee.setRenewalDate(renewalDate(employee));
        return totalCompensation;
    }

    /**
     * Getting current date and adding one year (Part1.2.f)
     * @param employee
     * @return 
     */
    @Override
    public Date renewalDate(Employee employee) {
        return java.sql.Date.valueOf(java.time.LocalDate.now().plusYears(1));
    }
}
