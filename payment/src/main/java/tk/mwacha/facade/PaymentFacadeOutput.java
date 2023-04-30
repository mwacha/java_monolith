package tk.mwacha.facade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentFacadeOutput(
        UUID transactionId,
        UUID orderId,
        BigDecimal amount,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
