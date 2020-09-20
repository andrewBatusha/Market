package com.coursework.demo.mapper;

import com.coursework.demo.dto.GoodDTO;
import com.coursework.demo.entity.Good;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodMapper {

    GoodDTO convertToDto(Good good);

    Good convertToEntity(GoodDTO goodDTO);

    List<GoodDTO> convertToDtoList(List<Good> goods);

}
