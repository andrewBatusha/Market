package com.coursework.demo.repository;

import com.coursework.demo.entity.Ledger;
import org.springframework.data.repository.CrudRepository;

public interface LedgerRepository extends CrudRepository<Ledger, Long> {
}
