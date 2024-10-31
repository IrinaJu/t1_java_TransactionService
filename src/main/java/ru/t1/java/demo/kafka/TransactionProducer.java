package ru.t1.java.demo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.t1.java.demo.model.dto.TransactionDTO;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionProducer {

    private final KafkaTemplate<String, List<TransactionDTO>> kafkaTemplate;

    public void sendTransaction(List<TransactionDTO> transactionDto) {
        try {
            kafkaTemplate.send("t1_demo_client_transactions", transactionDto);
            log.info("Транзакции успешно отправлены в топик: {}", transactionDto);
        } finally {
            kafkaTemplate.flush();
        }
    }
}





