package com.coursework.demo.repository;

import com.coursework.demo.entity.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodRepository extends CrudRepository<Good, Long> {
}
