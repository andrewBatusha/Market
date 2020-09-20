package com.coursework.demo.repository;

import com.coursework.demo.entity.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
}
