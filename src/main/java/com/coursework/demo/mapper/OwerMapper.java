package com.coursework.demo.mapper;

import com.coursework.demo.dto.OwerDTO;
import com.coursework.demo.entity.Ower;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwerMapper {

    OwerDTO convertToDto(Ower ower);

    Ower convertToEntity(OwerDTO owerDTO);

    List<OwerDTO> convertToDtoList(List<Ower> diagnoses);

}