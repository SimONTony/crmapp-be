package com.crmapp.core.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private boolean result;
    private String resultMessage;

    public ResultDto(String resultMessage) {
        this.resultMessage = resultMessage;
        this.result = true;
    }

}
