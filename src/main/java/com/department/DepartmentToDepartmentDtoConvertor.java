package com.department;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentDtoConvertor implements Converter<Department, DepartmentDto> {

    @Override
    public DepartmentDto convert(Department source) {
        return DepartmentDto.builder()
                .name(source.getName())
                .director(source.getDirector())
                .comment(source.getComment())
                .build();
    }

}
