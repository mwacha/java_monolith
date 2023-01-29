package tk.mwacha.usecase.addproduct;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.gateway.ProductGateway;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    @Mock
    private ProductGateway productRepository;
    @InjectMocks
    private AddProductUseCase useCase;

    @Test
    void should_add_product() {

        final var dto = AddProductDTO.builder()
                .name("Product 1")
                .description("Product 1 description")
                .purchasePrice(BigDecimal.valueOf(100))
                .stock(10).build();

        final var result = useCase.execute(dto);

        verify(productRepository, times(1)).add(result);


        assertNotNull(result.getId());
        assertTrue(result.getName().equals(dto.getName()));
        assertTrue(result.getDescription().equals(dto.getDescription()));
        assertTrue(result.getPurchasePrice().equals(dto.getPurchasePrice()));
        assertTrue(result.getStock() == dto.getStock());
    }

}