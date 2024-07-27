/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.service;

import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 *
 * @author moztu
 */
public interface PermanentEmployeeService extends EmployeeService {
    double calculateBonus(Employee employee);
    double pensionContribution(Employee employee);
}