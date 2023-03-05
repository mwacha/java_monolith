package tk.mwacha.usecase.checkstock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.addproduct.AddProductInputDto;
import tk.mwacha.usecase.addproduct.AddProductUseCase;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CheckStockUseCaseTest {

    @Mock
    private ProductGateway productGateway;
    @InjectMocks
    private CheckStockUseCase useCase;

    @Test
    void should_get_stock_of_a_product() {

        final var id = UUID.randomUUID();
        final var dto = new CheckStockInput(id);

        final var result = useCase.execute(dto);

        verify(productGateway, times(1)).add(any());

        assertNotNull(result.productId());
        assertTrue(result.productId().equals(id));

    }
}