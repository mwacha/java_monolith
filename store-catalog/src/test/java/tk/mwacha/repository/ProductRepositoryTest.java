package tk.mwacha.repository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    private static final UUID ID = UUID.randomUUID();

    @Mock
    private ProductRepository repository;


    @Test
    void should_find() {

        final var product = makeProduct();

        when(repository.find(product.getId().getValue())).thenReturn(product);

        final var productDB = repository.find(product.getId().getValue());

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.getId().getValue()));
        assertTrue(product.getName().equals(productDB.getName()));
        assertTrue(product.getDescription().equals(productDB.getDescription()));
        assertTrue(product.getPrice().setScale(2).equals(productDB.getPrice().setScale(2)));

    }

    @Test
    void should_find_all() {
        final var product = makeProduct();

        when(repository.findAll()).thenReturn(List.of(product));

        final var productDB = repository.findAll();

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.get(0).getId().getValue()));
        assertTrue(product.getName().equals(productDB.get(0).getName()));
        assertTrue(product.getDescription().equals(productDB.get(0).getDescription()));
        assertTrue(product.getPrice().setScale(2).equals(productDB.get(0).getPrice().setScale(2)));

    }

    private Product makeProduct() {
        final var product = Product.builder()
                .name("Product 1")
                .description("Product 1 description")
                .price(BigDecimal.valueOf(100)).build();

        product.addID(ID);

        return product;
    }
}