package com.coursework.demo.controller;

import com.coursework.demo.dto.GoodDTO;
import com.coursework.demo.entity.Good;
import com.coursework.demo.mapper.GoodMapper;
import com.coursework.demo.service.GoodService;
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
@Api(tags = "Good API")
@RequestMapping("/goods")
public class GoodController {

    private final GoodService goodService;
    private final GoodMapper goodMapper;

    @Autowired
    public GoodController(GoodService goodService, GoodMapper goodMapper) {
        this.goodService = goodService;
        this.goodMapper = goodMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get good info by id")
    public ResponseEntity<GoodDTO> get(@PathVariable("id") long id){
        Good good = goodService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(goodMapper.convertToDto(good));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all goods")
    public ResponseEntity<List<GoodDTO>> list() {
        return ResponseEntity.ok().body(goodMapper.convertToDtoList(goodService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new good")
    public ResponseEntity<GoodDTO> save(@RequestBody GoodDTO goodDTO) {
        Good good = goodService.save(goodMapper.convertToEntity(goodDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(goodMapper.convertToDto(good));
    }

    @PutMapping
    @ApiOperation(value = "Update existing good by id")
    public ResponseEntity<GoodDTO> update(@RequestBody GoodDTO goodDTO) {
        Good good = goodService.update(goodMapper.convertToEntity(goodDTO));
        return ResponseEntity.status(HttpStatus.OK).body(goodMapper.convertToDto(good));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete good by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Good good = goodService.getById(id);
        goodService.delete(good);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
