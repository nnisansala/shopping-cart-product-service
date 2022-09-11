package com.archi.training.introspect.shoping.cart.productservice.ddl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private String code;
    private String category;
    private String name;
    private String store;
    private String description;
    private boolean inStock;

    @Override
    public String toString() {
        return "Product [Code=" + code + ", Category=" + category + ", Name=" + name + ", Store"
                + store + ", Description=" + description + ", In Stock=" + inStock +"]";
    }
}
