package com.coursework.demo.mapper;

import com.coursework.demo.dto.ProductDTO;
import com.coursework.demo.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO convertToDto(Product product);

    Product convertToEntity(ProductDTO productDTO);

    List<ProductDTO> convertToDtoList(List<Product> products);

}
