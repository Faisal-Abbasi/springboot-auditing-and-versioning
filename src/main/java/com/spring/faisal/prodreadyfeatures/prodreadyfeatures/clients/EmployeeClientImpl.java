package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.clients;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.advice.ApiResponse;
import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.dto.EmployeeDTO;
import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.sql.SQLOutput;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    @Override
    public List<EmployeeDTO> getAllEmployee() {
        try{
             ApiResponse<List<EmployeeDTO>>  employeeDTO=restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>(){});
             return employeeDTO.getData();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
       try {
           ApiResponse<EmployeeDTO> employeeResponse= restClient.post()
                   .uri("employees")
                   .body(employeeDTO)
                   .retrieve()
                   .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                       System.out.println(new String(response.getBody().readAllBytes()));
                       throw new ResourceNotFoundException("could not found the employee");
                   }))
                   .body(new ParameterizedTypeReference<>() {
                   });
           return employeeResponse.getData();
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }
}
