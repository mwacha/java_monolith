package tk.mwacha.facade;

import tk.mwacha.domain.Product;
import tk.mwacha.usecase.find.FindProductInputDTO;
import tk.mwacha.usecase.find.FindProductOutputDTO;

import java.util.List;

public interface StoreCatalogFacadeInterface {

    FindProductOutputDTO find(FindProductInputDTO input);
    List<Product> findAll();
}
