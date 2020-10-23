package com.mainsoft.prueba.repository.daos;

import com.mainsoft.prueba.repository.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDao extends JpaRepository<Client, Long> {
}
