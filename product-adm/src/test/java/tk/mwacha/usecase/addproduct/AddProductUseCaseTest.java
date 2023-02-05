package tk.mwacha.usecase.addproduct;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.gateway.ProductGateway;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    @Mock
    private ProductGateway productGateway;
    @InjectMocks
    private AddProductUseCase useCase;

    @Test
    void should_add_product() {

        final var dto = AddProductInputDto.of(
                "Product 1",
                "Product 1 description",
                BigDecimal.valueOf(100),
                10);

        final var result = useCase.execute(dto);

        verify(productGateway, times(1)).create(any());


        assertNotNull(result.id());
        assertTrue(result.name().equals(dto.name()));
        assertTrue(result.description().equals(dto.description()));
        assertTrue(result.purchasePrice().equals(dto.purchasePrice()));
        assertTrue(result.stock() == dto.stock());
    }

}