package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Provider;
import com.coursework.demo.repository.ProviderRepository;
import com.coursework.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProviderServiceImpl implements ProviderService {

    ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider getById(Long id) {
        return providerRepository.findById(id).get();
    }

    @Override
    public List<Provider> getAll() {
        return (List<Provider>) providerRepository.findAll();
    }

    @Override
    public Provider update(Provider object) {
        return providerRepository.save(object);
    }

    @Override
    public Provider save(Provider object) {
        return providerRepository.save(object);
    }

    @Override
    public Provider delete(Provider object) {
        providerRepository.delete(object);
        return object;
    }
}
