package com.mainsoft.prueba.services;

import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.repository.entities.Sale;
import com.mainsoft.prueba.repository.entities.SaleDetail;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISalesServ extends IMapperObjects{
    ResponseEntity<List<SaleDto>> listSales();
    ResponseEntity<SaleDto> getSale(Long idSale);
    ResponseEntity<SaleDto> addSale(SaleDto saleDto);
    Observable<SaleDetail> getSaleDetails(Long idSale);

    Single<ResponseEntity<Sale>> getSaleDetails2(Long idSale);
}
