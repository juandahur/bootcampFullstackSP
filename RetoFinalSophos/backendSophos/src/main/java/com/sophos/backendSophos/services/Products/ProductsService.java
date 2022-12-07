package com.sophos.backendSophos.services.Products;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.models.Products;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductsService {

    List<Products> getAllProducts();

    List<Products> getProductsByClientId(Long id);

    Optional<Products> getProductById(Long id);

    Products createProductByClientId(ProductsCreateDto product, Long id);

    Products updateProductState(ProductsUpdateStateDto product, Long id);

    Optional<Products> findById(Long id);

}
