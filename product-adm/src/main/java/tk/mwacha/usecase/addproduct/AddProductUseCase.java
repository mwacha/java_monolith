package tk.mwacha.usecase.addproduct;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

@RequiredArgsConstructor
public class AddProductUseCase {
    
    private final ProductGateway productGateway;

    public AddProductOutputDto execute(AddProductInputDto dto) {
        final var product = Product.of(dto);

        product.generateID();
        productGateway.add(product);

        return AddProductOutputDto.from(product);

    }
}
