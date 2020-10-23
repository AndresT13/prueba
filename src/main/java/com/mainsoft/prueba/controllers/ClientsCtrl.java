package com.mainsoft.prueba.controllers;

import com.mainsoft.prueba.repository.dtos.ClientDto;
import com.mainsoft.prueba.services.IClientsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/clients")
public class ClientsCtrl {

    @Autowired
    private IClientsServ iClientsServ;

    @GetMapping()
    public ResponseEntity<List<ClientDto>> getClients(){
        return iClientsServ.listClients();
    }

    @GetMapping("{idClient}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long idClient){
        return iClientsServ.getClient(idClient);
    }
}
