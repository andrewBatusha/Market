package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Ower;
import com.coursework.demo.repository.OwerRepository;
import com.coursework.demo.service.OwerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class OwerServiceImpl implements OwerService {

    OwerRepository owerRepository;

    @Autowired
    public OwerServiceImpl(OwerRepository owerRepository) {
        this.owerRepository = owerRepository;
    }

    @Override
    public Ower getById(Long id) {
        return owerRepository.findById(id).get();
    }

    @Override
    public List<Ower> getAll() {
        return (List<Ower>) owerRepository.findAll();
    }

    @Override
    public Ower update(Ower object) {
        return owerRepository.save(object);
    }

    @Override
    public Ower save(Ower object) {
        return owerRepository.save(object);
    }

    @Override
    public Ower delete(Ower object) {
        owerRepository.delete(object);
        return object;
    }
}
