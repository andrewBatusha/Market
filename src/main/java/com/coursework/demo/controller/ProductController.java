package com.coursework.demo.controller;

import com.coursework.demo.dto.ProductDTO;
import com.coursework.demo.entity.Product;
import com.coursework.demo.mapper.ProductMapper;
import com.coursework.demo.service.ProductService;
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
@Api(tags = "Product API")
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product info by id")
    public ResponseEntity<ProductDTO> get(@PathVariable("id") long id) {
        Product product = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.convertToDto(product));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all products")
    public ResponseEntity<List<ProductDTO>> getAll(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(productMapper.convertToDtoList(productService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        Product product = productService.save(productMapper.convertToEntity(productDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.convertToDto(product));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing product by id")
    public ResponseEntity<ProductDTO> update(@PathVariable("id") long id, @RequestBody ProductDTO productDTO) {
        if (id == productDTO.getId()) {
            Product product = productService.update(productMapper.convertToEntity(productDTO));
            return ResponseEntity.status(HttpStatus.OK).body(productMapper.convertToDto(product));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Product product = productService.getById(id);
        productService.delete(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
