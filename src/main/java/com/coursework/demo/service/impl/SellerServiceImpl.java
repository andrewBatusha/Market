package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Seller;
import com.coursework.demo.repository.SellerRepository;
import com.coursework.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SellerServiceImpl implements SellerService {

    SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller getById(Long id) {
        return sellerRepository.findById(id).get();
    }

    @Override
    public List<Seller> getAll(Pageable pageable) {
        return sellerRepository.findAll(pageable).getContent();
    }

    @Override
    public Seller update(Seller object) {
        return sellerRepository.save(object);
    }

    @Override
    public Seller save(Seller object) {
        return sellerRepository.save(object);
    }

    @Override
    public Seller delete(Seller object) {
        sellerRepository.delete(object);
        return object;
    }
}
