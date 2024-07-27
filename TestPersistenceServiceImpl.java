/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;
import com.algonquin.cst8288.assignment1.service.PersistenceServiceImpl;

/**
 *
 * @author moztu
 */
@ExtendWith(MockitoExtension.class)
public class TestPersistenceServiceImpl {

    @InjectMocks
    private PersistenceServiceImpl service;

    @Mock
    private JSONFormatter jsonFormatter;

    @Mock
    private TextFormatter textFormatter;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("John Doe", "john.doe@example.com", 50000, 5);
    }

    @Test
    public void testSaveEmployeeJSON() throws IOException {
        when(jsonFormatter.format(employee)).thenReturn("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}");
        service.saveEmployee(employee, jsonFormatter, "json_employee_data.txt");
        
        File file = new File("json_employee_data.txt");
        assertTrue(file.exists());
        file.delete(); // Clean up
    }

    @Test
    public void testSaveEmployeeText() throws IOException {
        when(textFormatter.format(employee)).thenReturn("name=John Doe, email=john.doe@example.com");
        service.saveEmployee(employee, textFormatter, "text_employee_data.txt");
        
        File file = new File("text_employee_data.txt");
        assertTrue(file.exists());
        file.delete(); // Clean up
    }

    @Test
    public void testPrintEmployeeJSON() throws IOException {
        when(jsonFormatter.format(employee)).thenReturn("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}");
        
        service.printEmployee(employee, jsonFormatter);
        
        verify(jsonFormatter, times(1)).format(employee);
    }

    @Test
    public void testPrintEmployeeText() throws IOException {
        when(textFormatter.format(employee)).thenReturn("name=John Doe, email=john.doe@example.com");
        
        service.printEmployee(employee, textFormatter);
        
        verify(textFormatter, times(1)).format(employee);
    }
}
