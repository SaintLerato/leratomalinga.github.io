package com.example.risk.messaging;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener; import org.springframework.stereotype.Component;
@Component public class TransactionConsumer {
  private static final Logger log = LoggerFactory.getLogger(TransactionConsumer.class);
  @KafkaListener(topics = "transactions.v1", groupId = "risk-service")
  public void onMessage(ConsumerRecord<String, String> record){
    log.info("Received event: topic={} key={} value={}", record.topic(), record.key(), record.value());
    // TODO: parse JSON, compute risk score, publish decision
  }
}
