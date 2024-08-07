package com.spring.faisal.prodreadyfeatures.prodreadyfeatures;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.clients.EmployeeClient;
import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;
   @Test
    void getAllEmployees(){
       List<EmployeeDTO> employeeDTOList= employeeClient.getAllEmployee();
       System.out.println("The employee data is: "+ employeeDTOList);
   }
   @Test
    void getEmployeeById(){
       EmployeeDTO employeeById =employeeClient.getEmployeeById(1L);
       System.out.println("Employee by id is "+ employeeById);
   }
   @Test
    void createNewEmployee(){
       EmployeeDTO employeeDTO=new EmployeeDTO(null,"faisal","faisalabbasi@gmail.com",2,"ADMIN", 35999.0, LocalDate.of(2021,8,30),true);
       EmployeeDTO savedEmployee= employeeClient.createNewEmployee(employeeDTO);
       System.out.println("Saved employee is "+ savedEmployee);
   }
}
