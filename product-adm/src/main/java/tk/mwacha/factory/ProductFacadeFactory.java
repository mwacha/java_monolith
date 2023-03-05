package tk.mwacha.factory;

import tk.mwacha.facade.ProductFacade;
import tk.mwacha.repository.ProductRepository;
import tk.mwacha.usecase.addproduct.AddProductUseCase;
import tk.mwacha.usecase.checkstock.CheckStockUseCase;

public final class ProductFacadeFactory {

    public static ProductFacade create() {
        final var productRepository = new ProductRepository();
        final var addProductUseCase = new AddProductUseCase(productRepository);
        final var checkStockUseCase = new CheckStockUseCase(productRepository);

        return  new ProductFacade(addProductUseCase, checkStockUseCase);

    }
}
