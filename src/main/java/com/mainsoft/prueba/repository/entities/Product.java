package com.mainsoft.prueba.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idProduct;
    private String name;

    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal price;
}
