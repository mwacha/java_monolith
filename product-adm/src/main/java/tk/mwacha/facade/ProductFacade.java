package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.usecase.UseCaseInterface;
import tk.mwacha.usecase.addproduct.ProductInput;
import tk.mwacha.usecase.addproduct.ProductOutput;
import tk.mwacha.usecase.checkstock.CheckStockInput;
import tk.mwacha.usecase.checkstock.CheckStockOutput;

@RequiredArgsConstructor
public class ProductFacade implements ProductFacadeInterface {

    private final UseCaseInterface addUseCase;
    private final UseCaseInterface stockUseCase;
    @Override
    public ProductOutput addProduct(ProductInput input) {
        return (ProductOutput) this.addUseCase.execute(input);
    }

    @Override
    public CheckStockOutput checkStock(CheckStockInput input) {
        return (CheckStockOutput) this.stockUseCase.execute(input);
    }
}
