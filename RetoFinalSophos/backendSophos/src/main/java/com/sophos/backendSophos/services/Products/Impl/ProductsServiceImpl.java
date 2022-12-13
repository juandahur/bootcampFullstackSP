package com.sophos.backendSophos.services.Products.Impl;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
import com.sophos.backendSophos.dto.Products.ProductsUpdateStateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.models.Products;
import com.sophos.backendSophos.repository.ClientsRepository;
import com.sophos.backendSophos.repository.ProductsRepository;
import com.sophos.backendSophos.services.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    ClientsRepository clientsRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(Long id){
        return productsRepository.findById(id);
    }

    public List<Products> getProductsByClientId(Long id){
        return productsRepository.findByClientsId(id);
    }

    public Optional<Products> findById(Long id){
        return productsRepository.findById(id);
    }

    public Products updateProductState(ProductsUpdateStateDto productUpdate, Long id){

        Products newProduct = findById(id).get();
        newProduct.setProductState(productUpdate.getProductState());
        newProduct.setModifiedBy("Admin");
        newProduct.setModifiedOn(LocalDate.now());

        return productsRepository.save(newProduct);
    }

    public Products createProductByClientId(ProductsCreateDto product, Long id) {
        Clients newClient = clientsRepository.findById(id).get();

        List<String> listProductsId = new ArrayList<>();
        productsRepository.findAll().forEach(productId -> {
            listProductsId.add(productId.getId().toString());
        });

        Products newProduct = createNewProduct(newClient, listProductsId, product);
        return productsRepository.save(newProduct);
    }

    private Products createNewProduct(Clients newClient, List<String> listProductsId, ProductsCreateDto product){
        Products newProduct = new Products();
        newProduct.setClients(newClient);
        newProduct.setAccountNumber(accountNumberValidated(product.getAccountType(),listProductsId));
        newProduct.setAccountType(product.getAccountType());
        newProduct.setProductState("Active");
        newProduct.setAccountBalance(BigDecimal.ZERO);
        newProduct.setAvailableBalance(BigDecimal.ZERO);
        newProduct.setExemptGMT(false);
        newProduct.setCreatedBy("Admin");
        newProduct.setCreatedAt(LocalDate.now());
        newProduct.setModifiedBy("Admin");
        newProduct.setModifiedOn(LocalDate.now());

        return newProduct;
    }

    private static String accountNumberValidated(String productType, List<String> listProductsId){
        boolean validate = true;
        String generatedId = null;
        while (validate) {

            generatedId = generateProductId(productType);
            validate = findProductListId(generatedId, listProductsId);
        }
        return generatedId;
    }
    private static String generateProductId(String type) {
        String productId = "";
        if (type.equals("SA")) {
            productId = "46";

        } else if (type.equals("CA")) {
            productId = "23";
        }
        productId = appendString(productId);
        return productId;
    }

    private static String appendString(String typeString) {
        String appendedString = typeString;
        Random r = new Random();
        Integer randomNumber = 0;

        for (int i = 0; i <= 7; i++) {
            randomNumber = r.nextInt(0, 10);
            appendedString += randomNumber.toString();
        }

        return appendedString;
    }

    private static boolean findProductListId(String inputString, List<String> inputList) {
        boolean stringInList;
        stringInList = inputList.contains(inputString);

        return stringInList;
    }

}