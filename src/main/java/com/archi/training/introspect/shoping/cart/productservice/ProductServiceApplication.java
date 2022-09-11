package com.archi.training.introspect.shoping.cart.productservice;

import com.archi.training.introspect.shoping.cart.productservice.model.Product;
import com.archi.training.introspect.shoping.cart.productservice.repository.ProductRepository;
import com.archi.training.introspect.shoping.cart.productservice.util.ProductStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class ProductServiceApplication {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            productRepository.save(new Product("BEA123456", "BEAUTY", "Amanda Face Cream",  "Colombo, Sri Lanka", "This product is suitable for dry skin", ProductStatus.INSTOCK));
            productRepository.save(new Product("EDU45678", "EDUCATION", "Atlas HighLight Pen",  "Mumbai, India", "This contains two yellow color high light pens", ProductStatus.OUTOFSTOCK));
            productRepository.save(new Product("MOB23456", "MOBILE PHONE", "SAMSUNG A32",  "Gampaha, Sri Lanka", "8GB Memory, Black in Color", ProductStatus.INSTOCK));
            productRepository.save(new Product("BEA123456", "BEAUTY", "Amanda Hair Color",  "Colombo, Sri Lanka", "This product is suitable for gray hair", ProductStatus.INSTOCK));
            productRepository.save(new Product("HEA45678", "HEALTH", "Candres Drug",  "Colombo, Sri Lanka", "Pain Killer", ProductStatus.SUSPEND));
            productRepository.save(new Product("ELC34567", "ELECTRONIC", "DAMRO GRINDER",  "Mumbai, India", "Mini grinder with 2 cups and 4 speeds", ProductStatus.INSTOCK));

        };
    }
}


