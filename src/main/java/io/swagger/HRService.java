package io.swagger;

import java.util.*;
import io.swagger.model.Employee;
import io.swagger.model.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;



@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "")
@Controller

@Service
public class HRService {
    Employees employees = new Employees();

    public HRService() {
    }

    public Employees getEmployees() {
        return this.employees;
    }

    /**
     * Get Employee
     */
    public Employee getEmployeeId(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }


    /**
     * Set Employee
     */
    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }

    /**
     * DELETE Employee
     */
    public void deleteEmployees(int id ) {
        Employee employeeclone = null;

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeclone = employee;
            }
        }
        this.employees.remove(employeeclone);
        System.out.println("Employee sucessfuly deleted");
    }
}
