package com.mainsoft.prueba.repository.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String httpStatus;
    private String message;
    private Integer code;
    private String backendMessage;
}
