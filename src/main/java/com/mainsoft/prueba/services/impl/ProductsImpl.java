package com.mainsoft.prueba.services.impl;

import com.mainsoft.prueba.repository.daos.IProductDao;
import com.mainsoft.prueba.repository.dtos.ProductDto;
import com.mainsoft.prueba.services.IProductsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsImpl implements IProductsServ {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> list = iProductDao.findAll().stream()
                .map(this::convertProduct)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> getProduct(Long idProduct) {
        try{
            ProductDto productDto = convertProduct(iProductDao.getOne(idProduct));
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<ProductDto> addProduct(ProductDto product) {
        product = convertProduct(iProductDao.save(convertProductDto(product)));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> setProduct(ProductDto product, Long idProduct) {
        product.setIdProduct(idProduct);
        product = convertProduct(iProductDao.save(convertProductDto(product)));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> removeProduct(Long idProduct) {
        iProductDao.deleteById(idProduct);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
