package tk.mwacha.usecase.checkstock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CheckStockUseCaseTest {

    private static final UUID ID = UUID.randomUUID();
    private static final int STOCK = 10;

    @Mock
    private ProductGateway productGateway;
    @InjectMocks
    private CheckStockUseCase useCase;

    @Test
    void should_get_stock_of_a_product() {

        final var input = new CheckStockInput(ID);

        given(productGateway.find(ID))
                .willReturn(make(ID));


        final var result = useCase.execute(input);

        assertNotNull(result.productId());
        assertTrue(result.productId().equals(ID));
        assertTrue(result.stock() == STOCK);

    }

    private Product make(final UUID id) {
        final var product = Product.builder().stock(STOCK).build();
        product.addID(id);

        return product;
    }
}