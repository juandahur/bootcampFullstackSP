package com.sophos.backendSophos.services.Products.Impl;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.services.Products.ProductsService;
import com.sophos.backendSophos.services.Products.ProductsValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductsValidationsServiceImpl implements ProductsValidationsService {

    @Autowired
    ProductsService productsService;
    public boolean validateProductStateUpdate(ProductsUpdateStateDto productState, Long id){

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

    public boolean validateProductState(ProductsUpdateStateDto productState){
      if (productState.getProductState().equals("Active") || productState.getProductState().equals("Inactive")
                || productState.getProductState().equals("Cancelled")){
          return false;
      } return true;

    }

    public boolean validateProductAccountType(ProductsCreateDto productCreate){
        if (productCreate.getAccountType().equals("CA") || productCreate.getAccountType().equals("SA")){
            return false;
        } return true;
    }

}
