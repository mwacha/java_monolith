package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "transactions")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TransactionModel implements Serializable {

    @Id
    private UUID id;

    private UUID orderId;

    private BigDecimal amount;


    private String status;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
}
