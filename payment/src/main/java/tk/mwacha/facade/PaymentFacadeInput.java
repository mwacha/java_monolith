package tk.mwacha.facade;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentFacadeInput(UUID orderId, BigDecimal amount) {

    public static PaymentFacadeInput of(final UUID orderId, final BigDecimal amount) {
        return new PaymentFacadeInput(orderId, amount);
    }
}
