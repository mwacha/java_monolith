package tk.mwacha.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.gateway.PaymentGateway;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProcessPaymentUseCaseTest {
    @Mock
    private PaymentGateway gateway;
    @InjectMocks
    private ProcessPaymentUseCase useCase;

    private final static UUID ORDER_ID = UUID.randomUUID();
    @Test
    void should_approve_a_transaction() {
        final var input = new ProcessPaymentInput(ORDER_ID, BigDecimal.valueOf(100));

       final var result = useCase.execute(input);
        verify(gateway, times(1)).save(any());

        assertNotNull(result.transactionId());
        assertTrue(result.status().equals("approved"));
        assertTrue(result.orderId().equals(ORDER_ID));
        assertTrue(result.amount().equals(BigDecimal.valueOf(100)));

    }

    @Test
    void should_decline_a_transaction() {
        final var input = new ProcessPaymentInput(UUID.randomUUID(), BigDecimal.valueOf(50));

        final var result = useCase.execute(input);
        verify(gateway, times(1)).save(any());

        assertNotNull(result.transactionId());
        assertTrue(result.status().equals("declined"));
        assertTrue(result.amount().equals(BigDecimal.valueOf(50)));

    }
}