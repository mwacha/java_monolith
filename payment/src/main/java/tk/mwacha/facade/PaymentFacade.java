package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class PaymentFacade implements PaymentFacadeInterface{
    private final UseCaseInterface processPaymentUseCase;


    @Override
    public PaymentFacadeOutput process(PaymentFacadeInput input) {
        return (PaymentFacadeOutput) this.processPaymentUseCase.execute(input);
    }
}