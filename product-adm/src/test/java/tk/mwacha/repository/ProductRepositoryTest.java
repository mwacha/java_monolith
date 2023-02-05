package tk.mwacha.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {


    private ProductRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ProductRepository();
    }

    @Test
    void should_create() {
        final var product = Product.builder()
                .name("Product 1")
                .description("Product 1 description")
                .purchasePrice(BigDecimal.valueOf(100))
                .stock(10).build();

        product.generateID();

        repository.add(product);

        final var productDB = repository.find(product.getId().getValue());

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.getId().getValue()));
        assertTrue(product.getName().equals(productDB.getName()));
        assertTrue(product.getDescription().equals(productDB.getDescription()));
        assertTrue(product.getPurchasePrice().equals(productDB.getPurchasePrice()));
        assertTrue(product.getStock() == productDB.getStock());

    }

    @Test
    void should_find() {


        final var product = Product.builder()
                .name("Product 1")
                .description("Product 1 description")
                .purchasePrice(BigDecimal.valueOf(100))
                .stock(10).build();

        product.generateID();


        final var productDB = repository.find(product.getId().getValue());

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.getId().getValue()));
        assertTrue(product.getName().equals(productDB.getName()));
        assertTrue(product.getDescription().equals(productDB.getDescription()));
        assertTrue(product.getPurchasePrice().equals(productDB.getPurchasePrice()));
        assertTrue(product.getStock() == productDB.getStock());

    }
}