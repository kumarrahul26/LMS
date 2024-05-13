package com.example.minor.controller;

import com.example.minor.exception.TxnServiceException;
import com.example.minor.request.CreateReturnTxnRequest;
import com.example.minor.request.CreateTxnRequest;
import com.example.minor.response.TxnSettlementResponse;
import com.example.minor.service.TxnService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/create")
    public String create(@RequestBody @Valid  CreateTxnRequest createTxnRequest) throws TxnServiceException {
        return txnService.create(createTxnRequest);
    }

    @PostMapping("/return")
    public TxnSettlementResponse returnBook(@RequestBody CreateReturnTxnRequest createReturnTxnRequest) throws TxnServiceException {
        return txnService.returnbook(createReturnTxnRequest);
    }
}
