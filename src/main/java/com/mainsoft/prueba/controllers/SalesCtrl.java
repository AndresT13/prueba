package com.mainsoft.prueba.controllers;

import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.repository.entities.Sale;
import com.mainsoft.prueba.repository.entities.SaleDetail;
import com.mainsoft.prueba.services.ISalesServ;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/sales")
public class SalesCtrl {

    @Autowired
    private ISalesServ iSalesServ;

    @GetMapping()
    public ResponseEntity<List<SaleDto>> getSales(){
        return iSalesServ.listSales();
    }

    @GetMapping("{idSale}")
    public ResponseEntity<SaleDto> getSale(@PathVariable Long idSale){
        return iSalesServ.getSale(idSale);
    }

    @PostMapping(value = "add", consumes = {"application/json"})
    public ResponseEntity<SaleDto> addSale(@RequestBody SaleDto saleDto){
        return iSalesServ.addSale(saleDto);
    }

    @GetMapping(value = "rxjava", produces = {"application/json"}, consumes = {"application/json"})
    public Observable<SaleDetail> getSaleDetails(@RequestParam(value = "idSale") Long idSale) {
        return iSalesServ.getSaleDetails(idSale);
    }

    @GetMapping(value = "rxjava2", produces = {"application/json"}, consumes = {"application/json"})
    public Single<ResponseEntity<Sale>> getSaleDetails2(@RequestParam(value = "idSale") Long idSale) {
        return iSalesServ.getSaleDetails2(idSale);
    }
}
