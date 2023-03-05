package tk.mwacha.usecase.checkstock;

import lombok.RequiredArgsConstructor;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class CheckStockUseCase implements UseCaseInterface<CheckStockInput, CheckStockOutput> {

    private final ProductGateway productGateway;

    public CheckStockOutput execute(CheckStockInput input) {
        final var product = this.productGateway.find(input.productId());
        return CheckStockMapper.toOutput(product);
    }
}
