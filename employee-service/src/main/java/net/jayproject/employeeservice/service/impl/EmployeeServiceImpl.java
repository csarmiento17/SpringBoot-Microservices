package net.jayproject.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.jayproject.employeeservice.dto.EmployeeDto;
import net.jayproject.employeeservice.entity.Employee;
import net.jayproject.employeeservice.exceptions.ResourceNotFoundException;
import net.jayproject.employeeservice.mapper.AutoEmployeeMapper;
import net.jayproject.employeeservice.repository.EmployeeRepository;
import net.jayproject.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);


        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
