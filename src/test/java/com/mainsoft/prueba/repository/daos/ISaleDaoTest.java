package com.mainsoft.prueba.repository.daos;

import com.mainsoft.prueba.repository.dtos.ProductDto;
import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.repository.entities.Sale;
import com.mainsoft.prueba.services.ISalesServ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
class ISaleDaoTest {

    @Autowired
    private ISalesServ iSalesServ;

    @Test
    @Transactional
    @Rollback(true)
    void getSaleDetails() {
        ResponseEntity<SaleDto> sale = iSalesServ.getSale(1L);
        Assert.isTrue(sale.getStatusCodeValue()==404, "No se encontro el registro");
    }

}