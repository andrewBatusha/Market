package com.coursework.demo.repository;

import com.coursework.demo.entity.Seller;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellerRepository extends PagingAndSortingRepository<Seller, Long> {
}
