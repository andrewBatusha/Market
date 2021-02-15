package com.coursework.demo.controller;

import com.coursework.demo.dto.ProducerDTO;
import com.coursework.demo.entity.Producer;
import com.coursework.demo.mapper.ProducerMapper;
import com.coursework.demo.service.ProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@Api(tags = "Producer API")
@RequestMapping("/v1/producers")
public class ProducerController {

    private final ProducerService producerService;
    private final ProducerMapper producerMapper;

    @Autowired
    public ProducerController(ProducerService producerService, ProducerMapper producerMapper) {
        this.producerService = producerService;
        this.producerMapper = producerMapper;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get producer info by id")
    public ResponseEntity<ProducerDTO> get(@PathVariable("id") long id) {
        Producer producer = producerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(producerMapper.convertToDto(producer));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all producers")
    public ResponseEntity<List<ProducerDTO>> getAll(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(producerMapper.convertToDtoList(producerService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new producer")
    public ResponseEntity<ProducerDTO> save(@RequestBody ProducerDTO producerDTO) {
        Producer producer = producerService.save(producerMapper.convertToEntity(producerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(producerMapper.convertToDto(producer));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing producer by id")
    public ResponseEntity<ProducerDTO> update(@PathVariable("id") long id, @RequestBody ProducerDTO producerDTO) {
        if (id == producerDTO.getId()) {
            Producer producer = producerService.update(producerMapper.convertToEntity(producerDTO));
            return ResponseEntity.status(HttpStatus.OK).body(producerMapper.convertToDto(producer));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete producer by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Producer producer = producerService.getById(id);
        producerService.delete(producer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
