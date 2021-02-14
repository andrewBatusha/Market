package com.coursework.demo.mapper;

import com.coursework.demo.dto.ProducerDTO;
import com.coursework.demo.entity.Producer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    ProducerDTO convertToDto(Producer producer);

    Producer convertToEntity(ProducerDTO producerDTO);

    List<ProducerDTO> convertToDtoList(List<Producer> producers);

}