package io.swagger.api;

import io.swagger.HRService;
import io.swagger.model.Employee;
import io.swagger.model.Employees;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-27T14:38:21.509Z[GMT]")
@Controller
public class EmployeesApiController implements EmployeesApi {

    @Autowired
    private HRService hrService;
    private static final Logger log = LoggerFactory.getLogger(EmployeesApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EmployeesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Employees> employeesGet(@Min(10) @Max(20) @ApiParam(value = "The amount of employees returned", allowableValues = "") @Valid @RequestParam(value = "bodyLimit", required = false) Integer bodyLimit,@Min(1) @Max(5) @ApiParam(value = "The pages to  return employees info", allowableValues = "") @Valid @RequestParam(value = "pageLimit", required = false) Integer pageLimit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

                return new ResponseEntity<Employees>(hrService.getEmployees(), HttpStatus.OK);
                //return new ResponseEntity<Employees>(objectMapper.readValue("[ {\n  \"employee name\" : \"Matheus Silva\",\n  \"id\" : 4,\n  \"employee title\" : \"Beckend Developer\"\n}, {\n  \"employee name\" : \"Matheus Silva\",\n  \"id\" : 4,\n  \"employee title\" : \"Beckend Developer\"\n} ]", Employees.class), HttpStatus.NOT_IMPLEMENTED);

        }

        return new ResponseEntity<Employees>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<Employee> employeesIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
                return new ResponseEntity<Employee>(hrService.getEmployeeId(id), HttpStatus.OK);
        }

        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> employeesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Employee body) {
        String accept = request.getHeader("Accept");
        this.hrService.setEmployees(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Employees> employeesIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            this.hrService.deleteEmployees(id);
            return new ResponseEntity<Employees>(HttpStatus.OK);
        }
        return new ResponseEntity<Employees>(HttpStatus.OK);
    }

}
