package tk.mwacha.usecase.addproduct;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.repository.ProductModel;
import tk.mwacha.repository.ProductRepository;

@RequiredArgsConstructor
public class AddProductUseCase {
    
    private final ProductRepository productRepository;

    public Product execute(AddProductDTO dto) {
        final var product = ProductModel.of(dto);

        return Product.of(productRepository.save(product));

    }
}
