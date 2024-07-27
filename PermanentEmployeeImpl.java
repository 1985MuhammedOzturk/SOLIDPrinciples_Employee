package com.algonquin.cst8288.assignment1.service;

import com.algonquin.cst8288.assignment1.controller.Rate;
import com.algonquin.cst8288.assignment1.employee.Employee;


/**
 * 
 * @author moztu
 */
public class PermanentEmployeeImpl implements PermanentEmployeeService {

    /**
     * Calculates total compensation for permanent employee.
     * Salary+bonus (Part1.2.b)
     * @param employee
     * @return 
     */
    @Override
    public double calculateTotalCompensation(Employee employee) {
        double bonus = calculateBonus(employee);
        double pension = pensionContribution(employee);
        double totalCompensation = employee.getSalary() + bonus + pension;
        employee.setBonus(bonus);
        employee.setTotalCompensation(totalCompensation);
        return totalCompensation;
    }

    /**
     * Calculating bonus_rate multiplied by the number of service year.
     * Bonus rate is 0.025 and pension rate is 0.01 of the base salary
     * @param employee
     * @return 
     */
    @Override
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * Rate.BONUS_RATE * employee.getNumberOfServiceYear();
    }

    @Override
    public double pensionContribution(Employee employee) {
        return employee.getSalary() * Rate.PENSION_RATE;
    }
}
