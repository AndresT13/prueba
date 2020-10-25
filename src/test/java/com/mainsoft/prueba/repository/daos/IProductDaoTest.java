package com.mainsoft.prueba.repository.daos;

import com.google.gson.Gson;
import com.mainsoft.prueba.controllers.ClientsCtrl;
import com.mainsoft.prueba.repository.dtos.ProductDto;
import com.mainsoft.prueba.repository.entities.Product;
import com.mainsoft.prueba.services.IClientsServ;
import com.mainsoft.prueba.services.IProductsServ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
class IProductDaoTest {

    @Autowired
    private IProductsServ iProductsServ;

    @Test
    @Transactional
    @Rollback(true)
    void contextLoads() {

        ResponseEntity<ProductDto> product = iProductsServ.addProduct(ProductDto.builder()
                .name("Producto de prueba")
                .idProduct(1L)
                .build());

        ResponseEntity<ProductDto> productDtoResponseEntity = iProductsServ.getProduct(2L);
        Assert.isTrue(productDtoResponseEntity.getStatusCodeValue()==404, "No se encontro el registro");
    }

}