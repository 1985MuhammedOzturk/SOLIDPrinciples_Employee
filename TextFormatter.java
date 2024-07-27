package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;
import com.algonquin.cst8288.assignment1.employee.Employee;
/*
Responsible for saving the Employee object as key-value pairs (Part1.3)
*/
public class TextFormatter implements Formatter {

    @Override
    public String format(Employee employee) throws IOException {
        return String.format("name=%s, email=%s, address=%s, salary=%d, numberOfServiceYear=%d, bonus=%f, totalCompensation=%f",
                employee.getName(), employee.getEmail(), employee.getAddress(), (int) employee.getSalary(),
                employee.getNumberOfServiceYear(), employee.getBonus(), employee.getTotalCompensation());
    }
}
