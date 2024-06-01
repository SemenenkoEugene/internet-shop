package ru.semenenko.internetshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.semenenko.internetshop.dto.ProductDto;
import ru.semenenko.internetshop.entity.Product;

@Mapper(componentModel = "spring", uses = TypeProductMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.typeProduct", target = "typeProductDto")
    ProductDto topProductDto(Product product);

    Product fromEntity(ProductDto productDto);
}
