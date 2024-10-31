package ru.t1.java.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.java.demo.kafka.TransactionProducer;
import ru.t1.java.demo.model.dto.TransactionDTO;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transact")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionProducer transactionProducer;
    private final TransactionDTO transactionDto;

    @PostMapping("/new")
    public ResponseEntity<Object> createTransaction() {

        transactionProducer.sendTransaction((List<TransactionDTO>) transactionDto);
        return okResponse("Transaction success!", createTransaction());
    }

    private ResponseEntity<Object> okResponse(String message, Object body) {
        return ResponseEntity.ok()
                .header("Server", message)
                .body(body);
    }
}