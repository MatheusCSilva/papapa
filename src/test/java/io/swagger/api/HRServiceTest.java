package io.swagger.api;

import io.swagger.HRService;
import io.swagger.model.Employee;
import io.swagger.model.Employees;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HRServiceTest {

    private HRService hrService = new HRService();
    private Employees employeestest = new Employees();
    private Employee employeetest = new Employee();
    private Integer id=10;



    @Test
    public void getEmployeeIdTest() {
        //Given
        //When
        //Then
        for (Employee employee : employeestest) {
            if (employee.getId() == id)
                System.out.println(id);
        }
    }

    @Test
    public void deleteEmployees() {
        Employee employeeclone = null;

        for (Employee employee : employeestest) {
            if (employee.getId() == id) {
                employeeclone = employee;
            }
        }
        this.employeestest.remove(employeeclone);
        System.out.println("Employee sucessfuly deleted");
    }
}
