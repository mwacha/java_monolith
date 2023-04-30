package tk.mwacha.factory;

import tk.mwacha.facade.PaymentFacade;
import tk.mwacha.repository.TransactionRepostiory;
import tk.mwacha.usecase.ProcessPaymentUseCase;

public final class PaymentFacadeFactory {
    public static PaymentFacade create()  {
        final var paymentRepository = new TransactionRepostiory();
        final var usecase = new ProcessPaymentUseCase(paymentRepository);
        return  new PaymentFacade(usecase);
    }
}
