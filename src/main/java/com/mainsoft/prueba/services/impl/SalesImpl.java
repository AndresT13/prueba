package com.mainsoft.prueba.services.impl;

import com.google.gson.Gson;
import com.mainsoft.prueba.repository.daos.IClientDao;
import com.mainsoft.prueba.repository.daos.ISaleDao;
import com.mainsoft.prueba.repository.daos.ISaleDetailDao;
import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.repository.entities.Client;
import com.mainsoft.prueba.repository.entities.Sale;
import com.mainsoft.prueba.repository.entities.SaleDetail;
import com.mainsoft.prueba.services.ISalesServ;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesImpl implements ISalesServ {

    @Autowired
    private ISaleDao iSaleDao;

    @Autowired
    private IClientDao iClientDao;

    @Autowired
    private ISaleDetailDao iSaleDetailDao;

    @Override
    public ResponseEntity<List<SaleDto>> listSales() {
        List<SaleDto> dtoList = iSaleDao.findAll().stream()
                .map(this::convertSale)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaleDto> getSale(Long idSale) {
        try {
            SaleDto saleDto = convertSale(iSaleDao.getOne(idSale));
            return new ResponseEntity<>(saleDto, HttpStatus.OK);
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SaleDto> addSale(SaleDto saleDto) {
        try {
            Sale sale = convertSaleDto(saleDto);
            sale.setIdClient(iClientDao.save(sale.getIdClient()));
            sale.setDetails(iSaleDetailDao.saveAll(sale.getDetails()));
            saleDto = convertSale(iSaleDao.save(sale));
            return new ResponseEntity<>(saleDto, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Observable<SaleDetail> getSaleDetails(Long idSale) {
        return findSaleDetails(idSale);
    }

    @Override
    public Single<ResponseEntity<Sale>> getSaleDetails2(Long idSale) {
        return findSaleDetailsSingle(idSale);
    }

    private Observable<SaleDetail> findSaleDetails(Long idSale) {
        return Observable.fromIterable(iSaleDao.getOne(idSale).getDetails());
    }

    private Single<ResponseEntity<Sale>> findSaleDetailsSingle(Long idSale) {
        return Single.create(singleEmitter -> {
            Optional<Sale> sale = this.iSaleDao.findById(idSale);
            if (sale.isPresent()){
                singleEmitter.onSuccess(new ResponseEntity<>(sale.get(), HttpStatus.OK));
            }else{
                singleEmitter.onError(new EntityNotFoundException());
            }
        });
    }
}
