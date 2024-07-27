/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.service.ContractEmployeeImpl;

/**
 *
 * @author moztu
 */
public class TestContractEmployeeImpl {
    private ContractEmployeeImpl service;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        service = new ContractEmployeeImpl();
        employee = new Employee("Jane Smith", "jane.smith@example.com", 40000, 0);
    }

    @Test
    public void testCalculateTotalCompensation() {
        double expectedTotalCompensation = 40000;
        assertEquals(expectedTotalCompensation, service.calculateTotalCompensation(employee), 0.01);
    }

    @Test
    public void testRenewalDate() {
        java.sql.Date expectedDate = java.sql.Date.valueOf(java.time.LocalDate.now().plusYears(1));
        assertEquals(expectedDate, service.renewalDate(employee));
    }
}
