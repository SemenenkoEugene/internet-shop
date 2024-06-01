package ru.semenenko.internetshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.semenenko.internetshop.dto.TypeProductDto;
import ru.semenenko.internetshop.entity.TypeProduct;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, TypeProductMapper.class})
public interface TypeProductMapper {

    TypeProductMapper INSTANCE = Mappers.getMapper(TypeProductMapper.class);

    TypeProductDto toDto(TypeProduct typeProduct);
}
