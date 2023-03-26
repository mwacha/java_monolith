package tk.mwacha.facade;

import tk.mwacha.usecase.addproduct.ProductInput;
import tk.mwacha.usecase.addproduct.ProductOutput;
import tk.mwacha.usecase.checkstock.CheckStockInput;
import tk.mwacha.usecase.checkstock.CheckStockOutput;

public interface ProductFacadeInterface {
    ProductOutput addProduct(final ProductInput input);
    CheckStockOutput checkStock(final CheckStockInput input);
}
