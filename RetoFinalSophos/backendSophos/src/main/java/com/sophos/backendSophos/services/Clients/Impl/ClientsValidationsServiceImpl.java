package com.sophos.backendSophos.services.Clients.Impl;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Clients.ClientsValidationsService;
import com.sophos.backendSophos.services.Products.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class ClientsValidationsServiceImpl implements ClientsValidationsService {

    @Autowired
    ProductsService productsService;

    public boolean validateClientCreate(ClientsCreateDto clientCreate) {
        LocalDate date1 = clientCreate.getBirthDate();
        LocalDate date2 = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(date1, date2);
        return (diff<18);
    }

    public boolean validateClientUpdate(ClientsUpdateDto clientUpdate) {
        LocalDate date1 = clientUpdate.getBirthDate();
        LocalDate date2 = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(date1,date2);

        return (diff<18);
    }

    public boolean validateClientDelete(Long id){
        boolean validate = false;
        List<Products> productsList = productsService.getProductsByClientId(id);
        for(Products product: productsList){
            if ( (product.getProductState().equals("Cancelled"))){
                validate = true;
                break;
            }
        }
        return validate;
    }

}