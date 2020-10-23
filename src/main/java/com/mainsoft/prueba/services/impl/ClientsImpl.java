package com.mainsoft.prueba.services.impl;

import com.mainsoft.prueba.repository.daos.IClientDao;
import com.mainsoft.prueba.repository.dtos.ClientDto;
import com.mainsoft.prueba.services.IClientsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsImpl implements IClientsServ {
    @Autowired
    private IClientDao iClientDao;

    @Override
    public ResponseEntity<List<ClientDto>> listClients() {
        List<ClientDto> dtoList = iClientDao.findAll().stream()
                .map(this::convertClient)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDto> getClient(Long id) {
        return new ResponseEntity<>(convertClient(iClientDao.getOne(id)), HttpStatus.OK);
    }
}
