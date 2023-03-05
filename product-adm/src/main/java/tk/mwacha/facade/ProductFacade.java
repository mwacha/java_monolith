package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.usecase.UseCaseInterface;
import tk.mwacha.usecase.addproduct.AddProductUseCase;

@RequiredArgsConstructor
public class ProductFacade implements ProductFacadeInterface {

    private final UseCaseInterface addUseCase;
    private final UseCaseInterface stockUseCase;
    @Override
    public void addProduct(ProductFacadeInput input) {
        this.addUseCase.execute(input);
    }

    @Override
    public CheckStockFacadeOutput checkStock(CheckStockFacadeInput input) {
        return (CheckStockFacadeOutput) this.stockUseCase.execute(input);
    }
}
