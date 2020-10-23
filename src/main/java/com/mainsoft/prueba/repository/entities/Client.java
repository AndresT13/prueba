package com.mainsoft.prueba.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idClient;
    private String names;
    private String surnames;
    private String dni;
    private String phone;
    private String email;

}
