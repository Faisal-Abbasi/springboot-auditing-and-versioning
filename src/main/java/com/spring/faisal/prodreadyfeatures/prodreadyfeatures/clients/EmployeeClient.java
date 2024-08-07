package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.clients;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.dto.EmployeeDTO;
import java.util.*;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);

}
