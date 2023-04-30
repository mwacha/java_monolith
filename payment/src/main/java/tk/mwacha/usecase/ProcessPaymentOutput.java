package tk.mwacha.usecase;

import tk.mwacha.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProcessPaymentOutput(UUID transactionId,
                                   UUID orderId,
                                   BigDecimal amount,
                                   String status,
                                   LocalDateTime createdAt,
                                   LocalDateTime updatedAt) {

    public static ProcessPaymentOutput from(final Transaction transaction) {
        return new ProcessPaymentOutput(
                transaction.getId().getValue(),
                transaction.getOrderId(),
                transaction.getAmount(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt());
    }
}
