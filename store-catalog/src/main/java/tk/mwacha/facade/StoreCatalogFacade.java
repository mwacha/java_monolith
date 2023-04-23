package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.usecase.find.FindProductInputDTO;
import tk.mwacha.usecase.find.FindProductOutputDTO;
import tk.mwacha.usecase.find.FindProductUseCase;
import tk.mwacha.usecase.list.ListProductUseCase;

import java.util.List;

@RequiredArgsConstructor
public class StoreCatalogFacade implements StoreCatalogFacadeInterface {
    private final FindProductUseCase findUseCase;
    private final ListProductUseCase listUseCase;

    @Override
    public FindProductOutputDTO find(FindProductInputDTO input) {
        return this.findUseCase.execute(input);
    }

    public List<Product> findAll() {
        return this.listUseCase.execute();
    }
}