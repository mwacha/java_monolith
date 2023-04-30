package tk.mwacha.usecase;

import java.math.BigDecimal;
import java.util.UUID;

public record ProcessPaymentInput(UUID orderId, BigDecimal amount) {
}
