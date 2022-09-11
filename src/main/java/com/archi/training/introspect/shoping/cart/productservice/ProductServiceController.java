package com.archi.training.introspect.shoping.cart.productservice;

import com.archi.training.introspect.shoping.cart.productservice.ddl.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    private ProductServiceProvider productServiceProvider;


    @GetMapping(value = "getAllProducts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAllProducts() {
         LOGGER.info("[getAllProducts] [START] Request received to get all product details");
         List<Product> productList = productServiceProvider.getAllProducts();
         if(productList.isEmpty()) {
             LOGGER.info("[getAllProducts] [END] No registered product found");
             return new ResponseEntity<>("No Products Found", HttpStatus.OK);
         } else {
             LOGGER.info("[getAllProducts] [END] No of products {}", productList.size());
             return new ResponseEntity<>(productList, HttpStatus.OK);
         }
    }

    @GetMapping(value = "getProductByCode/{productCode}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getProductByCode(final @PathVariable("productCode") String productCode) {
        LOGGER.info("[getProductByCode][START] Request received to get product by code {}", productCode);
        try {
            Product product = productServiceProvider.getProductByCode(productCode);
            LOGGER.debug("[getProductByCode] {}", product);
            LOGGER.info("[getProductByCode][END] Product found for given code {}", productCode);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            LOGGER.info("[getProductByCode][END] Product not found for given code {}", productCode);
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
