package io.swagger.api;

import io.swagger.model.Employee;
import io.swagger.model.Employees;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesApiControllerIntegrationTest {

    @Autowired
    private EmployeesApi api;

    @Test
    public void employeesGetTest() throws Exception {
        Integer bodyLimit = 56;
        Integer pageLimit = 56;
        ResponseEntity<Employees> responseEntity = api.employeesGet(bodyLimit, pageLimit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void employeesIdGetTest() throws Exception {
        Integer id = 56;
        ResponseEntity<Employee> responseEntity = api.employeesIdGet(id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void employeesPostTest() throws Exception {
        Employee body = new Employee();
        ResponseEntity<Void> responseEntity = api.employeesPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
