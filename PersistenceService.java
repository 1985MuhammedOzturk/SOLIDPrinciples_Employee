package com.algonquin.cst8288.assignment1.service;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import java.io.IOException;
/**
 * Dependency inversion Principle (Part1.4)
 * @author moztu
 */
public interface PersistenceService {
    void saveEmployee(Employee employee, Formatter formatter, String filename) throws IOException;
    void printEmployee(Employee employee, Formatter formatter);
}
