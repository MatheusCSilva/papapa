package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;


import io.swagger.model.Employees;
/**
 * Model containing employee info
 */
@ApiModel(description = "Model containing employee info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-27T14:38:21.509Z[GMT]")
public class Employee   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("employee name")

  private String employeeName = null ;

  @JsonProperty("employee title")
  private String employeeTitle = null;

  public Employee id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "4", value = "")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employee employeeName(String employeeName) {
    this.employeeName = employeeName;
    return this;
  }

  /**
   * Get employeeName
   * @return employeeName
  **/
  @ApiModelProperty(example = "Matheus Silva", value = "")

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Employee employeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
    return this;
  }

  /**
   * Get employeeTitle
   * @return employeeTitle
  **/
  @ApiModelProperty(example = "Beckend Developer", value = "")

  public String getEmployeeTitle() {
    return employeeTitle;
  }

  public void setEmployeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.employeeName, employee.employeeName) &&
        Objects.equals(this.employeeTitle, employee.employeeTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, employeeName, employeeTitle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    employeeName: ").append(toIndentedString(employeeName)).append("\n");
    sb.append("    employeeTitle: ").append(toIndentedString(employeeTitle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
