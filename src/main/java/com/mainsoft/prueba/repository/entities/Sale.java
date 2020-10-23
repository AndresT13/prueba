package com.mainsoft.prueba.repository.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idSale;

    @JoinColumn(referencedColumnName = "idClient")
    @ManyToOne()
    private Client idClient;

    @JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date saleDate;

    @JoinColumn(referencedColumnName = "idSale")
    @OneToMany()
    private List<SaleDetail> details;
}
