package com.mainsoft.prueba.services;

import com.mainsoft.prueba.repository.dtos.ClientDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientsServ extends IMapperObjects{
    ResponseEntity<List<ClientDto>> listClients();
    ResponseEntity<ClientDto> getClient(Long id);
}
