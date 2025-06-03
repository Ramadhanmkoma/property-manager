package com.mkomafamily.property.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkomafamily.property.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> findContractsByContractStatus(String status);

}
