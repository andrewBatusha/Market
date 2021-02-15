package com.coursework.demo.controller;

import com.coursework.demo.dto.SellerDTO;
import com.coursework.demo.entity.Seller;
import com.coursework.demo.mapper.SellerMapper;
import com.coursework.demo.service.SellerService;
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
@Api(tags = "Seller API")
@RequestMapping("/v1/sellers")
public class SellerController {

    private final SellerService sellerService;
    private final SellerMapper sellerMapper;

    @Autowired
    public SellerController(SellerService sellerService, SellerMapper sellerMapper) {
        this.sellerService = sellerService;
        this.sellerMapper = sellerMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get seller info by id")
    public ResponseEntity<SellerDTO> get(@PathVariable("id") long id) {
        Seller seller = sellerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(sellerMapper.convertToDto(seller));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all sellers")
    public ResponseEntity<List<SellerDTO>> getAll(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(sellerMapper.convertToDtoList(sellerService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new seller")
    public ResponseEntity<SellerDTO> save(@RequestBody SellerDTO sellerDTO) {
        Seller seller = sellerService.save(sellerMapper.convertToEntity(sellerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerMapper.convertToDto(seller));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing seller by id")
    public ResponseEntity<SellerDTO> update(@PathVariable("id") long id, @RequestBody SellerDTO sellerDTO) {
        if (id == sellerDTO.getId()) {
            Seller seller = sellerService.update(sellerMapper.convertToEntity(sellerDTO));
            return ResponseEntity.status(HttpStatus.OK).body(sellerMapper.convertToDto(seller));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete seller by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Seller seller = sellerService.getById(id);
        sellerService.delete(seller);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
