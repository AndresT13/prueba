package com.mainsoft.prueba.services;

import com.mainsoft.prueba.repository.dtos.ClientDto;
import com.mainsoft.prueba.repository.dtos.ProductDto;
import com.mainsoft.prueba.repository.dtos.SaleDetailDto;
import com.mainsoft.prueba.repository.dtos.SaleDto;
import com.mainsoft.prueba.repository.entities.Client;
import com.mainsoft.prueba.repository.entities.Product;
import com.mainsoft.prueba.repository.entities.Sale;
import com.mainsoft.prueba.repository.entities.SaleDetail;

import java.util.stream.Collectors;

public interface IMapperObjects {
    default SaleDto convertSale(Sale sale){
        return  SaleDto.builder()
                .idSale(sale.getIdSale())
                .details(
                        sale.getDetails().stream()
                                .map(this::convertSaleDetail)
                                .collect(Collectors.toList())
                )
                .idClient(convertClient(sale.getIdClient()))
                .saleDate(sale.getSaleDate())
                .build();
    }

    default SaleDetailDto convertSaleDetail(SaleDetail saleDetail){
        return SaleDetailDto.builder()
                .idProduct(convertProduct(saleDetail.getIdProduct()))
                .idSaleDetail(saleDetail.getIdSaleDetail())
                .build();
    }

    default SaleDetail convertSaleDetailDto(SaleDetailDto saleDetailDto){
        return new SaleDetail(
                saleDetailDto.getIdSaleDetail(),
                saleDetailDto.getIdSale(),
                convertProductDto(saleDetailDto.getIdProduct())
        );
    }

    default Sale convertSaleDto(SaleDto saleDto){
        return new Sale(
                saleDto.getIdSale(),
                convertClientDto(saleDto.getIdClient()),
                saleDto.getSaleDate(),
                saleDto.getDetails().stream()
                        .map(this::convertSaleDetailDto)
                        .collect(Collectors.toList())
        );
    }

    default ClientDto convertClient(Client client){
        return ClientDto.builder()
                .idClient(client.getIdClient())
                .dni(client.getDni())
                .names(client.getNames())
                .surnames(client.getSurnames())
                .phone(client.getPhone())
                .email(client.getEmail())
                .build();
    }

    default Client convertClientDto(ClientDto clientDto){
        return new Client(
                clientDto.getIdClient(),
                clientDto.getNames(),
                clientDto.getSurnames(),
                clientDto.getDni(),
                clientDto.getPhone(),
                clientDto.getEmail());
    }

    default ProductDto convertProduct(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .idProduct(product.getIdProduct())
                .build();
    }

    default Product convertProductDto(ProductDto product){
        return new Product(product.getIdProduct(), product.getName(), product.getPrice());
    }
}
