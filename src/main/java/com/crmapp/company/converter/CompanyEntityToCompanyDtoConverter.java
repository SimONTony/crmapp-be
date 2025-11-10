package com.crmapp.company.converter;

import com.crmapp.company.CompanyDto;
import com.crmapp.company.CompanyEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyEntityToCompanyDtoConverter implements Converter<CompanyEntity, CompanyDto> {

    @Override
    public CompanyDto convert(CompanyEntity source) {
        return CompanyDto.builder()
                .companyId(source.getCompanyId())
                .companyName(source.getCompanyName())
                .alias(source.getAlias())
                .inn(source.getInn())
                .phone(source.getPhone())
                .email(source.getEmail())
                .address(source.getAddress())
                .founding(source.getFounding())
                .categoryOfActivity(source.getCategoryOfActivity())
                .edrpou(source.getEdrpou())
                .build();
    }


}
