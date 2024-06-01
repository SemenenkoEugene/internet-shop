package ru.semenenko.internetshop.service;

import ru.semenenko.internetshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();
}
