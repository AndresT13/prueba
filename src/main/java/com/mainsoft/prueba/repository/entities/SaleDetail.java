package com.mainsoft.prueba.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sale_details")
public class SaleDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idSaleDetail;

    @Column(name = "id_sale")
    private Long idSale;

    @JoinColumn(referencedColumnName = "idProduct")
    @ManyToOne()
    private Product idProduct;
}
