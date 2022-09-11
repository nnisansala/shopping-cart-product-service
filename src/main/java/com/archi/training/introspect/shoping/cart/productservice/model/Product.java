package com.archi.training.introspect.shoping.cart.productservice.model;

import com.archi.training.introspect.shoping.cart.productservice.util.ProductStatus;
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
    private ProductStatus status;
}
