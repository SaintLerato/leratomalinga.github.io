package com.example.transaction.messaging;
import com.example.transaction.domain.Transaction;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate; import org.springframework.stereotype.Component;
@Component public class TransactionProducer {
  private static final Logger log = LoggerFactory.getLogger(TransactionProducer.class);
  public static final String TOPIC = "transactions.v1";
  private final KafkaTemplate<String, Object> kafka;
  public TransactionProducer(KafkaTemplate<String, Object> kafka){ this.kafka = kafka; }
  public void publish(Transaction tx){ String key = tx.getAccountId()==null? String.valueOf(tx.getId()): tx.getAccountId();
    log.info("Publishing transaction id={} topic={} key={}", tx.getId(), TOPIC, key);
    kafka.send(TOPIC, key, tx); }
}
