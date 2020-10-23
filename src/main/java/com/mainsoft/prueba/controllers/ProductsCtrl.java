package com.mainsoft.prueba.controllers;

import com.mainsoft.prueba.repository.dtos.ProductDto;
import com.mainsoft.prueba.services.IProductsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/products")
public class ProductsCtrl {

    @Autowired
    private IProductsServ iProductsServ;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(){
        return iProductsServ.listProducts();
    }

    @GetMapping("{idProduct}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long idProduct){
        return iProductsServ.getProduct(idProduct);
    }

    @PostMapping(value = "add", consumes = {"application/json"})
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        return iProductsServ.addProduct(productDto);
    }

    @PutMapping(value = "edit/{idProduct}", consumes = {"application/json"})
    public ResponseEntity<ProductDto> setProduct(@RequestBody ProductDto productDto, @PathVariable Long idProduct){
        return iProductsServ.setProduct(productDto, idProduct);
    }

    @DeleteMapping(value = "remove", consumes = {"application/json"})
    public ResponseEntity<String> removeProduct(@RequestParam Long idProduct){
        return iProductsServ.removeProduct(idProduct);
    }
}
