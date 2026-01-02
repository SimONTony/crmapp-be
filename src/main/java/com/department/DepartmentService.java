package com.department;

import com.crmapp.employee.EmployeeRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentDtoToDepartmentEntityConvector departmentDtoToDepartmentEntityConvector;

    @Autowired
    private DepartmentToDepartmentDtoConvertor departmentToDepartmentDtoConvector;

    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = departments.stream()
                .map(department -> departmentToDepartmentDtoConvector.convert(department))
                .toList();
        return departmentDtos;

    }



}
