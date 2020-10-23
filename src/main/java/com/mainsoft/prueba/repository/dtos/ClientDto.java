package com.mainsoft.prueba.repository.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private Long idClient;
    private String names;
    private String surnames;
    private String dni;
    private String phone;
    private String email;
}
