package tk.mwacha.usecase.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ListProductUseCaseTest {
    private static final UUID ID_1 = UUID.randomUUID();
    private static final UUID ID_2 = UUID.randomUUID();

    @Mock
    private ProductGateway productGateway;

    @InjectMocks
    private ListProductUseCase useCase;

    @Test
    void find_all_products_usecase_unit_test() {

    final var mockList = makeList();
        given(productGateway.findAll())
                .willReturn(makeList());

    final var result =  useCase.execute();

        assertNotNull(result.size() == 2);
        assertTrue(result.get(0).getId().getValue().equals(mockList.get(0).getId().getValue()));
        assertTrue(result.get(0).getName().equals(mockList.get(0).getName()));
        assertTrue(result.get(0).getDescription().equals(mockList.get(0).getDescription()));
        assertTrue(result.get(0).getPrice().equals(mockList.get(0).getPrice()));


        assertTrue(result.get(1).getId().getValue().equals(mockList.get(1).getId().getValue()));
        assertTrue(result.get(1).getName().equals(mockList.get(1).getName()));
        assertTrue(result.get(1).getDescription().equals(mockList.get(1).getDescription()));
        assertTrue(result.get(1).getPrice().equals(mockList.get(1).getPrice()));
    }

    private List<Product> makeList() {
      final var product1 = Product.builder()
                      .name("Product 1").description("Description 1").price(BigDecimal.valueOf(100)).build();

      product1.addID(ID_1);

        final var product2 = Product.builder()
                .name("Product 2").description("Description 2").price(BigDecimal.valueOf(200)).build();

        product2.addID(ID_2);

        return List.of(product1, product2);

    }
}