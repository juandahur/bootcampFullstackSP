package com.sophos.backendSophos.services.Products;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.models.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

    List<Products> getAllProducts();

    List<Products> getProductsByClientId(Long id);

    Products create(ProductsCreateDto product);

}
