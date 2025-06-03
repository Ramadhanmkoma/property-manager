package com.mkomafamily.property.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkomafamily.property.model.Contract;
import com.mkomafamily.property.service.ContractService;


@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    // get All
    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        return ResponseEntity.ok(this.contractService.getAllContracts());
    }

    // get one (Unique)
    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long contractId) {
        Contract contract = this.contractService.getContractById(contractId).orElseThrow(
            () -> new RuntimeException("No Contract matching the id was found")
        );

        return ResponseEntity.ok(contract);
    }

    // find by status
    @GetMapping("/{contractStatus}")
    public ResponseEntity<List<Contract>> getByContractStatus(@PathVariable String contractStatus) {
        return ResponseEntity.ok(this.contractService.getContractsByStatus(contractStatus));
    }

    // Register New Contract
    @PostMapping
    public ResponseEntity<Contract> registerNewContract(@RequestBody Contract contract) {
        Contract newContract = contractService.saveContract(contract);

        return new ResponseEntity<>(newContract, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contract> updateOwner(@PathVariable Long id, @RequestBody Contract contract) {
        Contract contractToUpdate = contractService.getContractById(id).orElseThrow(
            () -> new RuntimeException("Contract with id \"" + id + "\" Does not Exists")
        );
        
        contractToUpdate.setStartDate(contract.getStartDate());
        contractToUpdate.setContractStatus(contract.getContractStatus());
        contractToUpdate.setProperty(contract.getProperty());
        contractToUpdate.setEnDateTime(contract.getEnDateTime());
        contractToUpdate.setAdditionalTerms(contract.getAdditionalTerms());
        contractToUpdate.setPaymentTerms(contract.getPaymentTerms());
        contractToUpdate.setTenant(contract.getTenant());

        Contract updatedContract = contractService.saveContract(contractToUpdate);

        return new ResponseEntity<>(updatedContract, HttpStatus.OK);
    }

    // Delete Contract
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable Long id) {
        Contract contract = contractService.getContractById(id).orElseThrow(
            () -> new RuntimeException("Contract with id: \"" + id + "\" Does not exists")
        );

        contractService.deleteContract(contract);
        return ResponseEntity.ok("Contract was deleted Successfully");
    }
}
