package com.example.transaction.domain;
import jakarta.persistence.*; import lombok.Getter; import lombok.Setter; import java.time.OffsetDateTime;
@Entity @Table(name="transactions") @Getter @Setter
public class Transaction {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  private String accountId; private double amount; private String currency; private String channel;
  private OffsetDateTime createdAt;
}
