package com.coursework.demo.repository;

import com.coursework.demo.entity.Producer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProducerRepository extends PagingAndSortingRepository<Producer, Long> {
}
