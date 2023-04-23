package tk.mwacha.usecase.find;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FindProductUseCaseTest {

    @Mock
    private ProductGateway productGateway;

    @InjectMocks
    private FindProductUseCase useCase;

    @Test
    void should_find() {

        final var product = makeProduct();
        given(productGateway.find(product.getId().getValue()))
                .willReturn(product);

        final var result =  useCase.execute(new FindProductInputDTO(product.getId().getValue()));

        assertNotNull(result);
        assertTrue(result.id().equals(product.getId().getValue()));
        assertTrue(result.name().equals(product.getName()));
        assertTrue(result.description().equals(product.getDescription()));
        assertTrue(result.price().equals(product.getPrice()));


    }
    private Product makeProduct() {
        final var product = Product.builder()
                .name("Product 1")
                .description("Product 1 description")
                .price(BigDecimal.valueOf(100)).build();

        product.addID(UUID.randomUUID());

        return product;
    }

}