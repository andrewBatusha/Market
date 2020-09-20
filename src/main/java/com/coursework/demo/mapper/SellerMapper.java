package com.coursework.demo.mapper;

import com.coursework.demo.dto.SellerDTO;
import com.coursework.demo.entity.Seller;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerDTO convertToDto(Seller seller);

    Seller convertToEntity(SellerDTO sellerDTO);

    List<SellerDTO> convertToDtoList(List<Seller> licens);

}
