package com.archi.training.introspect.shoping.cart.productservice;

import com.archi.training.introspect.shoping.cart.productservice.ddl.Product;
import com.archi.training.introspect.shoping.cart.productservice.repository.ProductRepository;
import com.archi.training.introspect.shoping.cart.productservice.util.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceProvider.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        LOGGER.debug("[getAllProducts] Querying to get all products");
        final List<com.archi.training.introspect.shoping.cart.productservice.model.Product> productsFromDb = productRepository.getAll();
        LOGGER.debug("[getAllProducts] Querying completed and {} products found", productsFromDb.size());
        return productsFromDb.stream().map(product->new Product(product.getCode(), product.getCategory(),  product.getName(), product.getStore(), product.getDescription(),
                ProductStatus.INSTOCK.equals(product.getStatus()) ? true: false))
                .collect(Collectors.toList());

    }


    public Product getProductByCode(final String code) {
        LOGGER.debug("[getProductByCode] Querying to get products by code {}", code);
        final com.archi.training.introspect.shoping.cart.productservice.model.Product productFromDb = productRepository.getByCode(code);
        if (productFromDb != null) {
            LOGGER.debug("[getProductByCode] Querying completed for product with code {}", productFromDb.getCode());
            return new Product(productFromDb.getCode(), productFromDb.getCategory(),  productFromDb.getName(), productFromDb.getStore(), productFromDb.getDescription(),
                    ProductStatus.INSTOCK.equals(productFromDb.getStatus()) ? true: false);
        }
        throw new ProductNotFoundException("SVC0001", "Products not found for given code");
    }
}
