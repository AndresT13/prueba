package com.mainsoft.prueba.repository.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class SaleDto {
    private Long idSale;
    private ClientDto idClient;
    private List<SaleDetailDto> details;

    @JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date saleDate;
}
