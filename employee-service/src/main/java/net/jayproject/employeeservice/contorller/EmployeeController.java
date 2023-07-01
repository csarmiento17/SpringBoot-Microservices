package net.jayproject.employeeservice.contorller;

import lombok.AllArgsConstructor;
import net.jayproject.employeeservice.dto.APIResponseDto;
import net.jayproject.employeeservice.dto.EmployeeDto;
import net.jayproject.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployeeDto = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{empId}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("empId") Long id) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);

        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
