package com.department;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoToDepartmentEntityConvector implements Converter<DepartmentDto, Department> {

    @Override
    public Department
    convert(DepartmentDto source) {
        return Department.builder()
                .name(source.getName())
                .director(source.getDirector())
                .comment(source.getComment())
                .build();
    }
}


