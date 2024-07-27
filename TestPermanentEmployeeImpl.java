/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.service.PermanentEmployeeImpl;

/**
 *
 * @author moztu
 */
public class TestPermanentEmployeeImpl {
    private PermanentEmployeeImpl service;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        service = new PermanentEmployeeImpl();
        employee = new Employee("John Doe", "john.doe@example.com", 50000, 5);
    }

    @Test
    public void testCalculateBonus() {
        double expectedBonus = 50000 * 0.025 * 5;
        assertEquals(expectedBonus, service.calculateBonus(employee), 0.01);
    }

    @Test
    public void testPensionContribution() {
        double expectedPension = 50000 * 0.01;
        assertEquals(expectedPension, service.pensionContribution(employee), 0.01);
    }

    @Test
    public void testCalculateTotalCompensation() {
        double expectedTotalCompensation = 50000 + service.calculateBonus(employee) + service.pensionContribution(employee);
        assertEquals(expectedTotalCompensation, service.calculateTotalCompensation(employee), 0.01);
    }
}

