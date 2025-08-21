package com.example.transaction.api;
import com.example.transaction.domain.Transaction;
import com.example.transaction.domain.TransactionRepository;
import com.example.transaction.messaging.TransactionProducer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;

@RestController @RequestMapping("/api/transactions")
public class TransactionController {
  private final TransactionRepository repo; private final TransactionProducer producer;
  public TransactionController(TransactionRepository repo, TransactionProducer producer) { this.repo = repo; this.producer = producer; }
  @PostMapping public ResponseEntity<Transaction> create(@Valid @RequestBody TransactionCreateRequest req) {
    Transaction tx = new Transaction(); tx.setAccountId(req.accountId()); tx.setAmount(req.amount());
    tx.setCurrency(req.currency()); tx.setChannel(req.channel()); tx.setCreatedAt(OffsetDateTime.now());
    Transaction saved = repo.save(tx); producer.publish(saved); return ResponseEntity.ok(saved); }
  @GetMapping public List<Transaction> list() { return repo.findAll(); }
  public record TransactionCreateRequest(String accountId, double amount, String currency, String channel) {}
}
