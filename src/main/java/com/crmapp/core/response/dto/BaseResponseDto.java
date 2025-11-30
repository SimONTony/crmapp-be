package com.crmapp.core.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto<D> {

    protected D data;
    protected boolean success;
    protected int statusCode;
    protected String message;

    public BaseResponseDto(D data) {
        this.data = data;
        this.success = true;
        this.statusCode = HttpStatus.OK.value();
        this.message = "";
    }
}
