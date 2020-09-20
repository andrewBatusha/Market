package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Good;
import com.coursework.demo.repository.GoodRepository;
import com.coursework.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GoodServiceImpl implements GoodService {

    GoodRepository goodRepository;

    @Autowired
    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public Good getById(Long id) {
        return goodRepository.findById(id).get();
    }

    @Override
    public List<Good> getAll() {
        return (List<Good>) goodRepository.findAll();
    }

    @Override
    public Good update(Good object) {
        return goodRepository.save(object);
    }

    @Override
    public Good save(Good object) {
        return goodRepository.save(object);
    }

    @Override
    public Good delete(Good object) {
        goodRepository.delete(object);
        return object;
    }
}
