package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping
    private ResponseEntity<List<Products>> listProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Products>> listProductsByClient(@PathVariable("id") Long id){

        return ResponseEntity.ok(productsService.getProductsByClientId(id));
    }

    @PostMapping("/{id}")
    private ResponseEntity saveProductByClientId(@RequestBody ProductsCreateDto productCreate,@PathVariable("id") Long id) {

        try {
            Products temporal = productsService.createProductByClientId(productCreate,id);
            return ResponseEntity.created(new URI("/products" + temporal.getId())).body(temporal);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/state/{id}")
    private ResponseEntity updateState(@RequestBody ProductsUpdateStateDto productState, @PathVariable Long id) {


        try {
            if(!(productState.getProductState().equals("Active") || productState.getProductState().equals("Inactive")
                    || productState.getProductState().equals("Cancelled"))){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide a different Product State");
            }

            if(validateProductStateUpdate(productState,id)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check accounts balance");
            }
            Products temporal = productsService.updateProductState(productState, id);
            return ResponseEntity.created(new URI("/products" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("State update error");
        }
    }

    private boolean validateProductStateUpdate(ProductsUpdateStateDto productState,Long id){

          if(productState.getProductState().equals("Cancelled")){

              Products newProduct = productsService.findById(id).get();
              System.out.println(newProduct.getAccountBalance().compareTo(new BigDecimal(1)));
              System.out.println(newProduct.getAccountBalance().compareTo(new BigDecimal(0)));
              if((newProduct.getAccountBalance().compareTo(new BigDecimal(1))<=0)
              && (newProduct.getAccountBalance().compareTo(new BigDecimal(0))>=0)){
                    return false;
              } return true;
          }
            return false;
    }


}
