package com.mainsoft.prueba.repository.daos;

import com.mainsoft.prueba.repository.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDao extends JpaRepository<Product, Long> {
}
