package tk.mwacha.factory;

import tk.mwacha.facade.StoreCatalogFacade;
import tk.mwacha.repository.ProductRepository;
import tk.mwacha.usecase.find.FindProductUseCase;
import tk.mwacha.usecase.list.ListProductUseCase;

public final class StoreCatalogFacadeFactory {

    public static StoreCatalogFacade create()  {
        final var productRepository = new ProductRepository();
        final var findProductUseCase = new FindProductUseCase(productRepository);
    final var listUseCase = new ListProductUseCase(productRepository);
        return  new StoreCatalogFacade(findProductUseCase, listUseCase);
    }
}
