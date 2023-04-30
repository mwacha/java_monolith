package tk.mwacha.repository;

import org.junit.jupiter.api.*;
import tk.mwacha.domain.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepostioryTest {
    private TransactionRepostiory repository;

    private static final UUID ORDER_ID = UUID.randomUUID();
    private static final UUID TRANSACTION_ID = UUID.randomUUID();

    @BeforeEach
    void setup() {
        this.repository = new TransactionRepostiory();
    }

    @Test
    void should_save_a_transaction() {

        final var transaction = Transaction.builder()
                .amount(BigDecimal.valueOf(100))
                        .orderId(ORDER_ID).build();

        transaction.addID(TRANSACTION_ID);

        transaction.approve();

        final var transactionDB = repository.save(transaction);


        assertNotNull(transactionDB);
        assertTrue(transaction.getId().getValue().equals(transactionDB.getId().getValue()));
        assertTrue(transaction.getStatus().equals("approved"));
        assertTrue(transaction.getAmount().equals(transactionDB.getAmount()));
        assertTrue(transaction.getOrderId().equals(transactionDB.getOrderId()));
    }
}