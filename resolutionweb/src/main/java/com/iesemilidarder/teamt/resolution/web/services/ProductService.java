package com.iesemilidarder.teamt.resolution.web.services;


import com.iesemilidarder.teamt.resolution.web.domain.Product;


public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);
}
