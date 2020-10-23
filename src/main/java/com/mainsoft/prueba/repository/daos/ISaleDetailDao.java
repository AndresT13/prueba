package com.mainsoft.prueba.repository.daos;

import com.mainsoft.prueba.repository.entities.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleDetailDao extends JpaRepository<SaleDetail, Long> {

    @Query(value = "select d from sale_details d where d.idSale.idSale=:idSale")
    List<SaleDetail> findAllByIdSaleEquals(@Param("idSale") Long idSale);
}
