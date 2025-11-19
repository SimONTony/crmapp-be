//package com.crmapp.contracts;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping(name = "/contracts")
//public class ContractController {
//
//    @Autowired
//    private ContractService contractService;
//
//    //@Autowired
//    //private ContractEntityToDtoConvector contractEntityToDtoConvector;
//
//    @GetMapping
//    public List<ContractDto> getAllContracts() {
//        List<ContractDto> contracts = contractService.getAllContracts();
//        return contracts;
//    }
//
//    @GetMapping(value = "/{contractId}")
//    public ContractDto getContractById(@PathVariable Integer contractId) {
//        ContractDto contract = contractService.getContractById((contractId));
//        return contract;
//    }
//
//    @DeleteMapping
//    public void deleteContract(@PathVariable Integer contractId) {
//        contractService.deleteContract(contractId);
//    }
//
//    @PostMapping(value = "/addContract")
//    public ResponseEntity<ContractDto> addContract(@RequestBody ContractDto contract) {
//        ContractDto saveContract = contractService.addContract(ContractDto);
//        return ResponseEntity.ok(saveContract);
//    }
//
//}


