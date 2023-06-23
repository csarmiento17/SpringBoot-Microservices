package net.jayproject.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.jayproject.departmentservice.dto.DepartmentDto;
import net.jayproject.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    //Dependency Injection
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody  DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String deptCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(deptCode);

        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
