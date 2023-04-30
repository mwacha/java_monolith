package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.TransactionModel;
import tk.mwacha.usecase.ProcessPaymentInput;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
public class Transaction extends BaseEntity implements AggregateRoot {
    private BigDecimal amount;
    private UUID orderId;
    private String status;

    public static Transaction of(TransactionModel transactionModel) {
        final var transaction  = Transaction.builder()
                .amount(transactionModel.getAmount())
                .orderId(transactionModel.getOrderId())
                .status(transactionModel.getStatus())
                .build();

        transaction.addID(transactionModel.getId());

        return transaction;
    }

    public static Transaction of(final ProcessPaymentInput input) {
        return Transaction.builder()
                .amount(input.amount())
                .orderId(input.orderId())
                .build();
    }

    void validate() {
        if (this.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Error("Amount must be greater than 0");
        }
    }

    public void approve() {
        this.status = "approved";
    }

    private void decline() {
        this.status = "declined";
    }

    public void process() {
        if (this.amount.compareTo(BigDecimal.valueOf(100)) >= 0) {
            this.approve();
        } else {
            this.decline();
        }
    }

}
