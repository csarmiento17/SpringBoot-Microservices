package net.jayproject.employeeservice.service;

import net.jayproject.employeeservice.dto.APIResponseDto;
import net.jayproject.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
