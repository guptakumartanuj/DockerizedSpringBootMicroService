package com.dtechgeek.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtechgeek.demo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
