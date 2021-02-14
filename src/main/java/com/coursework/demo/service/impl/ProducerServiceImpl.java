package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Producer;
import com.coursework.demo.repository.ProducerRepository;
import com.coursework.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProducerServiceImpl implements ProducerService {

    ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producer getById(Long id) {
        return producerRepository.findById(id).get();
    }

    @Override
    public List<Producer> getAll(Pageable pageable) {
        return producerRepository.findAll(pageable).getContent();
    }

    @Override
    public Producer update(Producer object) {
        return producerRepository.save(object);
    }

    @Override
    public Producer save(Producer object) {
        return producerRepository.save(object);
    }

    @Override
    public Producer delete(Producer object) {
        producerRepository.delete(object);
        return object;
    }
}
