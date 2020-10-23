package com.mainsoft.prueba.repository.daos;

import com.mainsoft.prueba.repository.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDao extends JpaRepository<Sale,Long> {
}
