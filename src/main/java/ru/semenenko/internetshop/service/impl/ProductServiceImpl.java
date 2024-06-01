package ru.semenenko.internetshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.semenenko.internetshop.dto.ProductDto;
import ru.semenenko.internetshop.entity.Product;
import ru.semenenko.internetshop.mapper.ProductMapper;
import ru.semenenko.internetshop.repository.ProductRepository;
import ru.semenenko.internetshop.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.fromProductDto(productDto);

        Product saveProduct = productRepository.save(product);
        return productMapper.toProductDto(saveProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProductDto)
                .toList();
    }
}
