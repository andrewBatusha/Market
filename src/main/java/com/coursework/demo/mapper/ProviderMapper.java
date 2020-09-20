package com.coursework.demo.mapper;

import com.coursework.demo.dto.ProviderDTO;
import com.coursework.demo.entity.Provider;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    ProviderDTO convertToDto(Provider provider);

    Provider convertToEntity(ProviderDTO providerDTO);

    List<ProviderDTO> convertToDtoList(List<Provider> providers);

}