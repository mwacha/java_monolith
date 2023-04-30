package tk.mwacha.usecase;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Transaction;
import tk.mwacha.gateway.PaymentGateway;

@RequiredArgsConstructor
public class ProcessPaymentUseCase implements UseCaseInterface<ProcessPaymentInput, ProcessPaymentOutput > {
    private final PaymentGateway gateway;

   @Override
    public ProcessPaymentOutput execute(ProcessPaymentInput input) {
        final var transaction = Transaction.of(input);

        transaction.process();

        transaction.generateID();
        gateway.save(transaction);

        return ProcessPaymentOutput.from(transaction);

    }

}
