package com.mainsoft.prueba.repository.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private Long idProduct;
    private String name;
    private BigDecimal price;
}
