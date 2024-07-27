package com.algonquin.cst8288.assignment1.controller;



import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;
import com.algonquin.cst8288.assignment1.service.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.service.EmployeeService;
import com.algonquin.cst8288.assignment1.service.PersistenceService;
import com.algonquin.cst8288.assignment1.service.PersistenceServiceImpl;
import com.algonquin.cst8288.assignment1.service.PermanentEmployeeImpl;
import java.io.IOException;

/**
 * 
 * @author moztu
 * 
 * Main Class to execute the application
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        /*
        Creating a permanent employee
        */
        Employee permanentEmployee = new Employee("John Doe", "john.doe@example.com", 50000, 5);
        /*
        Creating a contract employee
        */
        Employee contractEmployee = new Employee("Jane Smith", "jane.smith@example.com", 40000, 0);
        
        /*
        Creating a service instance for the permanent employee
        */
        EmployeeService permanentService = new PermanentEmployeeImpl();
        /*
        Creating a service instance for the contract employee
        */
        EmployeeService contractService = new ContractEmployeeImpl();

        /*
        Creating a persistance service instance
        */
        PersistenceService persistenceService = new PersistenceServiceImpl();
        /*
        Creating controller instance for permanenet employee 
        */
        EmployeeController permanentController = new EmployeeController(permanentService, persistenceService);
         /*
        Creating controller instance for contract employee 
        */
        EmployeeController contractController = new EmployeeController(contractService, persistenceService);

        String permanentResult = permanentController.processEmployee(permanentEmployee);
        String contractResult = contractController.processEmployee(contractEmployee);

        /*
        Printing the result for both permanent and contract employees.
        */
        System.out.println("Permanent Employee Processing Result: " + permanentResult);
        System.out.println("Contract Employee Processing Result: " + contractResult);

        /*
        Checking condiditon and saving/printing the permanent employee data 
        */
        if (permanentResult.equals("SUCCESS")) {
            permanentController.saveEmployee(permanentEmployee, new JSONFormatter(), "json_employee_data.txt");
            permanentController.printEmployee(permanentEmployee, new JSONFormatter());
        }
         /*
        Checking condiditon and saving/printing the contract employee data 
        */
        if (contractResult.equals("SUCCESS")) {
            contractController.saveEmployee(contractEmployee, new TextFormatter(), "text_employee_data.txt");
            contractController.printEmployee(contractEmployee, new TextFormatter());
        }
    }
}
