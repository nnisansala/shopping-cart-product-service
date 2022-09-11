package com.archi.training.introspect.shoping.cart.productservice.repository;

import com.archi.training.introspect.shoping.cart.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    private static List<Product> productList = new ArrayList<>();

    public void save(final Product product) {
        productList.add(product);
    }


    public List<Product> getAll() {
        return productList;
    }


    public Product getByCode(final String code) {
        List<Product> filteredProducts = productList.stream().filter(product -> product.getCode().contains(code))
                .collect(Collectors.toList());
        if(filteredProducts.isEmpty()) {
            return null;
        }
        return filteredProducts.get(0);
    }


}
