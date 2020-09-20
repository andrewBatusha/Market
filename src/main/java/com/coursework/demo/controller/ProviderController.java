package com.coursework.demo.controller;

import com.coursework.demo.dto.ProviderDTO;
import com.coursework.demo.entity.Provider;
import com.coursework.demo.mapper.ProviderMapper;
import com.coursework.demo.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Provider API")
@RequestMapping("/providers")
public class ProviderController {

    private final ProviderService providerService;
    private final ProviderMapper providerMapper;

    @Autowired
    public ProviderController(ProviderService providerService, ProviderMapper providerMapper) {
        this.providerService = providerService;
        this.providerMapper = providerMapper;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get provider info by id")
    public ResponseEntity<ProviderDTO> get(@PathVariable("id") long id){
        Provider provider = providerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(providerMapper.convertToDto(provider));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all providers")
    public ResponseEntity<List<ProviderDTO>> list() {
        return ResponseEntity.ok().body(providerMapper.convertToDtoList(providerService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new provider")
    public ResponseEntity<ProviderDTO> save(@RequestBody ProviderDTO providerDTO) {
        Provider provider = providerService.save(providerMapper.convertToEntity(providerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(providerMapper.convertToDto(provider));
    }

    @PutMapping
    @ApiOperation(value = "Update existing provider by id")
    public ResponseEntity<ProviderDTO> update(@RequestBody ProviderDTO providerDTO) {
        Provider provider = providerService.update(providerMapper.convertToEntity(providerDTO));
        return ResponseEntity.status(HttpStatus.OK).body(providerMapper.convertToDto(provider));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete provider by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Provider provider = providerService.getById(id);
        providerService.delete(provider);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
