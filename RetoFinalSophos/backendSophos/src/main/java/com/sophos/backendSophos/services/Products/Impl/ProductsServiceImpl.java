package com.sophos.backendSophos.services.Products.Impl;

import com.sophos.backendSophos.dto.Products.ProductsCreateDto;
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

    public Products createProductByClientId(ProductsCreateDto product, Long id) {

        Products newProduct = new Products();
        Clients newClient = clientsRepository.findById(id).get();
        newProduct.setClients(newClient);
        List<String> listProductsId = new ArrayList<>();
        productsRepository.findAll().forEach(productId -> {
            listProductsId.add(productId.getId().toString());
        });
        String productType = product.getAccountType();
        System.out.println(productType);
        newProduct.setAccountNumber(accountNumberValidated(productType,listProductsId));
        newProduct.setAccountType(product.getAccountType());
        newProduct.setProductState("Active");

        BigDecimal bigDecimalAccountBalance = new BigDecimal(0);
        newProduct.setAccountBalance(bigDecimalAccountBalance);

        BigDecimal bigDecimalAvailableBalance = new BigDecimal(0);
        newProduct.setAvailableBalance(bigDecimalAvailableBalance);

        newProduct.setExemptGMT(false);

        newProduct.setCreatedBy("Admin");
        newProduct.setCreatedAt(LocalDate.now());
        newProduct.setModifiedBy("Admin");
        newProduct.setModifiedOn(LocalDate.now());


        return productsRepository.save(newProduct);
    }

    static String accountNumberValidated(String productType, List<String> listProductsId){
        boolean validate = true;
        String generatedId = null;
        while (validate) {

            generatedId = generateProductId(productType);
            validate = findProductListId(generatedId, listProductsId);
        }
        return generatedId;
    }
    static String generateProductId(String type) {
        String productId = "";
        if (type.equals("SA")) {
            productId = "46";

        } else if (type.equals("CA")) {
            productId = "23";
        }
        productId = appendString(productId);
        return productId;
    }

    static String appendString(String typeString) {
        String appendedString = typeString;
        Random r = new Random();
        Integer randomNumber = 0;

        for (int i = 0; i <= 7; i++) {
            randomNumber = r.nextInt(0, 10);
            appendedString += randomNumber.toString();
        }

        return appendedString;
    }

    static boolean findProductListId(String inputString, List<String> inputList) {
        boolean stringInList;
        stringInList = inputList.contains(inputString);

        return stringInList;
    }



}
