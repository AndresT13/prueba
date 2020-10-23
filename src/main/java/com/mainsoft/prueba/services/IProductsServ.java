package com.mainsoft.prueba.services;

import com.mainsoft.prueba.repository.dtos.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductsServ extends IMapperObjects{
    ResponseEntity<List<ProductDto>> listProducts();
    ResponseEntity<ProductDto> getProduct(Long idProduct);
    ResponseEntity<ProductDto> addProduct(ProductDto product);
    ResponseEntity<ProductDto> setProduct(ProductDto product, Long idProduct);
    ResponseEntity<String> removeProduct(Long idProduct);
}
