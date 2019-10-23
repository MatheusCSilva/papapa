package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.HRService;
import io.swagger.model.Employee;
import io.swagger.model.Employees;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)

@SpringBootTest
public class EmployeesApiControllerTest {

    @Autowired
    private HttpServletRequest request;
    private EmployeesApiController employeesApiController;
    @InjectMocks
    private HRService hrService;
    private ObjectMapper objectMapper;
    private Employee bodytest = new Employee();
    private Integer id=10;

    @Before
    public void setup(){
        hrService = mock(HRService.class);
        objectMapper=mock(ObjectMapper.class);
        request = mock(HttpServletRequest.class);
        employeesApiController = new EmployeesApiController(objectMapper, request);
    }

    //employeesApiContoller.

    @Test
    public void employeesPostTest() {
        this.hrService.setEmployees(bodytest);
    }

    @Test
    public void deleteEmployees_givenValidId_employeeIsDeleted() {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            this.hrService.deleteEmployees(id);
        //Given
        when(request.getHeader("Accept")).thenReturn("application/json");
        //Mockito.doReturn(null).when(hrService).deleteEmployees(44);
        doNothing().when(hrService).deleteEmployees(44);

        //When
        ResponseEntity<Employees> responseEntity = employeesApiController.employeesIdDelete(44);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("list should be empty", 0, employeesApiController.employeesGet(7,1).getBody().size());
    }

    @Test
    public void employeesGetTest() {
        Integer bodyLimit = 7;
        Integer pageLimit = 1;
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
            System.out.println(bodyLimit + pageLimit);
    }

    @Test
    public void employeesIdGetTest() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
           System.out.println(id);
    }
}