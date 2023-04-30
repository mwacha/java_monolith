package tk.mwacha.facade;

import org.junit.jupiter.api.BeforeEach;
import tk.mwacha.factory.PaymentFacadeFactory;
import tk.mwacha.repository.TransactionRepostiory;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFacadeTest {

    private TransactionRepostiory transactionRepostiory;

    @BeforeEach
    void setup() {
        this.transactionRepostiory = new TransactionRepostiory();
    }

    void should_create_a_transaction() {
        final var transactionFacade = PaymentFacadeFactory.create();

        final var input = PaymentFacadeInput.of(
                UUID.randomUUID(),
                BigDecimal.valueOf(100));

        final var output = transactionFacade.process(input);

        assertNotNull(output.transactionId());
        assertTrue(output.orderId().equals(input.orderId()));
        assertTrue(output.amount().equals(input.amount()));
        assertTrue(output.status().equals("approved"));

    }

}