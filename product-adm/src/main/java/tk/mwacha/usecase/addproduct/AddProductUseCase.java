package tk.mwacha.usecase.addproduct;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class AddProductUseCase implements UseCaseInterface<ProductInput, ProductOutput> {

    private final ProductGateway productGateway;

    public ProductOutput execute(ProductInput input) {
        final var product = Product.of(input);

        product.generateID();
        productGateway.add(product);

        return ProductOutput.from(product);

    }
}
