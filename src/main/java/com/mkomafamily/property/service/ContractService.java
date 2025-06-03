package com.mkomafamily.property.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mkomafamily.property.model.Contract;
import com.mkomafamily.property.repository.ContractRepository;

@Service
public class ContractService {

    private final ContractRepository cRepository;

    public ContractService(ContractRepository cRepository) {
        this.cRepository = cRepository;
    }

    // get All Contracts
    public List<Contract> getAllContracts() {
        return this.cRepository.findAll();
    }

    // get one
    public Optional<Contract> getContractById(Long id) {
        return this.cRepository.findById(id);
    }

    // get by status
    public List<Contract> getContractsByStatus(String status) {
        return this.cRepository.findContractsByContractStatus(status);
    }

    // add new
    public Contract saveContract(Contract contract) {
        return this.cRepository.save(contract);
    }


    // delete contract
    public void deleteContract(Contract contract) {
        cRepository.delete(contract);
    }
}
