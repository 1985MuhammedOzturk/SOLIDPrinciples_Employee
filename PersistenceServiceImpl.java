package com.algonquin.cst8288.assignment1.service;

import java.io.FileWriter;
import java.io.IOException;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of PersistanceService interface
 * @author moztu
 */
public class PersistenceServiceImpl implements PersistenceService {

    /**
     * Saves the employee data to a file using the formatter
     * @param employee
     * @param formatter
     * @param filename
     * @throws IOException 
     */
    @Override
    public void saveEmployee(Employee employee, Formatter formatter, String filename) throws IOException {
        String formattedData = formatter.format(employee);
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.write(formattedData);
        }
    }
    /**
     * Prints the employee data to a file using the formatter.
     * @param employee
     * @param formatter 
     */
    @Override
    public void printEmployee(Employee employee, Formatter formatter) {
        String formattedData = null;
        try {
            formattedData = formatter.format(employee);
        } catch (IOException ex) {
            Logger.getLogger(PersistenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(formattedData);
    }
}
