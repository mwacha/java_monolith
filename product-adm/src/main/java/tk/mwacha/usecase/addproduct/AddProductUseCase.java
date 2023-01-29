package tk.mwacha.usecase.addproduct;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

@RequiredArgsConstructor
public class AddProductUseCase {
    
    private final ProductGateway productRepository;

    public Product execute(AddProductDTO dto) {
        final var product = Product.of(dto);

        return productRepository.add(product);

    }
}
