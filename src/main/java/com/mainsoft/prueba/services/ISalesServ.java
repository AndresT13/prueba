package com.mainsoft.prueba.services;

import com.mainsoft.prueba.repository.dtos.SaleDto;
import io.reactivex.Single;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISalesServ extends IMapperObjects{
    ResponseEntity<List<SaleDto>> listSales();
    ResponseEntity<SaleDto> getSale(Long idSale);
    ResponseEntity<SaleDto> addSale(SaleDto saleDto);
    Single<SaleDto> getSaleDetails(Long idSale);
}
