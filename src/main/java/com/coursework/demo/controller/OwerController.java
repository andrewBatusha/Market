package com.coursework.demo.controller;

import com.coursework.demo.dto.OwerDTO;
import com.coursework.demo.entity.Ower;
import com.coursework.demo.mapper.OwerMapper;
import com.coursework.demo.service.OwerService;
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
@Api(tags = "Ower API")
@RequestMapping("/owers")
public class OwerController {

    private final OwerService owerService;
    private final OwerMapper owerMapper;

    @Autowired
    public OwerController(OwerService owerService, OwerMapper owerMapper) {
        this.owerService = owerService;
        this.owerMapper = owerMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get ower info by id")
    public ResponseEntity<OwerDTO> get(@PathVariable("id") long id){
        Ower ower = owerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(owerMapper.convertToDto(ower));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all owers")
    public ResponseEntity<List<OwerDTO>> list() {
        return ResponseEntity.ok().body(owerMapper.convertToDtoList(owerService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new ower")
    public ResponseEntity<OwerDTO> save(@RequestBody OwerDTO owerDTO) {
        Ower ower = owerService.save(owerMapper.convertToEntity(owerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(owerMapper.convertToDto(ower));

    }

    @PutMapping
    @ApiOperation(value = "Update existing ower by id")
    public ResponseEntity<OwerDTO> update(@RequestBody OwerDTO owerDTO) {
        Ower ower = owerService.update(owerMapper.convertToEntity(owerDTO));
        return ResponseEntity.status(HttpStatus.OK).body(owerMapper.convertToDto(ower));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete ower by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Ower ower = owerService.getById(id);
        owerService.delete(ower);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
