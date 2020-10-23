package com.mainsoft.prueba.repository.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleDetailDto {
    private Long idSaleDetail;
    private Long idSale;
    private ProductDto idProduct;
}
