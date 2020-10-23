package com.mainsoft.prueba.services.impl;

import com.mainsoft.prueba.repository.daos.ISaleDao;
import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.services.ISalesServ;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesImpl implements ISalesServ {

    @Autowired
    private ISaleDao iSaleDao;

    @Override
    public ResponseEntity<List<SaleDto>> listSales() {
        List<SaleDto> dtoList = iSaleDao.findAll().stream()
                .map(this::convertSale)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaleDto> getSale(Long idSale) {
        SaleDto saleDto = convertSale(iSaleDao.getOne(idSale));
        return new ResponseEntity<>(saleDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaleDto> addSale(SaleDto saleDto) {
        saleDto = convertSale(iSaleDao.save(convertSaleDto(saleDto)));
        return new ResponseEntity<>(saleDto, HttpStatus.OK);
    }

    @Override
    public Single<SaleDto> getSaleDetails(Long idSale) {
        return findSaleDetails(idSale);
    }

    private Single<SaleDto> findSaleDetails(Long idSale) {
        return Single.create(singleSubscriber -> singleSubscriber.onSuccess(convertSale(iSaleDao.getOne(idSale))));
    }
}
