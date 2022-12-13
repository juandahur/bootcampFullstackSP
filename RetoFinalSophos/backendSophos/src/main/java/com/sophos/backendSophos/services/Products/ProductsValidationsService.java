package com.sophos.backendSophos.services.Products;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;

public interface ProductsValidationsService {

    boolean validateProductStateUpdate(ProductsUpdateStateDto productState, Long id);

    boolean validateProductState(ProductsUpdateStateDto productState);
    boolean validateProductAccountType(ProductsCreateDto productCreate);

}
