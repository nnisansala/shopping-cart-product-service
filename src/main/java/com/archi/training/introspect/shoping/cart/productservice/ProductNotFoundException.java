package com.archi.training.introspect.shoping.cart.productservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductNotFoundException extends  RuntimeException {

    private String errorCode;
    private String errorText;

}
