package net.jayproject.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.jayproject.departmentservice.dto.DepartmentDto;
import net.jayproject.departmentservice.entity.Department;
import net.jayproject.departmentservice.exception.ResourceNotFoundException;
import net.jayproject.departmentservice.mapper.AutoDepartmentMapper;
import net.jayproject.departmentservice.repository.DepartmentRepository;
import net.jayproject.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    //@Autowired - no need spring bean has single parameter constructor
    //spring will automatically inject dependency
    private DepartmentRepository departmentRepository;


    // Use @AllArgsConstructor instead
//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Convert Department dto to JPA entity
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if (department == null) {
            throw new ResourceNotFoundException("Department", "code", departmentCode);
        }

        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }


}
