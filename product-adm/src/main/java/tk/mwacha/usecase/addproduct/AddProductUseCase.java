package tk.mwacha.usecase.addproduct;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class AddProductUseCase implements UseCaseInterface<AddProductInputDto, AddProductOutputDto> {

    private final ProductGateway productGateway;

    public AddProductOutputDto execute(AddProductInputDto input) {
        final var product = Product.of(input);

        product.generateID();
        productGateway.add(product);

        return AddProductOutputDto.from(product);

    }
}
