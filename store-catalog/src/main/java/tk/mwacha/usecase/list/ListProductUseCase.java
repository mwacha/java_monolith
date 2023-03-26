package tk.mwacha.usecase.list;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.DefaultUseCaseInterface;


import java.util.List;

@RequiredArgsConstructor
public class ListProductUseCase implements DefaultUseCaseInterface {
    private final ProductGateway productGateway;

    @Override
    public List<Product> execute() {
        return productGateway.findAll();
    }


}
