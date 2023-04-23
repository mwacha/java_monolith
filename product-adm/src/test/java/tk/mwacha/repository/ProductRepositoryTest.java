package tk.mwacha.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tk.mwacha.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest  {


    private static final UUID ID = UUID.randomUUID();

    private ProductRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ProductRepository();
    }

    @Test
    @Order(1)
    void should_create() {

        final var product = makeProduct();

        repository.add(product);

        final var productDB = repository.find(product.getId().getValue());

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.getId().getValue()));
        assertTrue(product.getName().equals(productDB.getName()));
        assertTrue(product.getDescription().equals(productDB.getDescription()));
        assertTrue(product.getPurchasePrice().setScale(2).equals(productDB.getPurchasePrice()));
        assertTrue(product.getStock() == productDB.getStock());

    }

    @Test
    @Order(2)
    void should_find() {
        final var product = makeProduct();

        final var productDB = repository.find(product.getId().getValue());

        assertNotNull(productDB);
        assertTrue(product.getId().getValue().equals(productDB.getId().getValue()));
        assertTrue(product.getName().equals(productDB.getName()));
        assertTrue(product.getDescription().equals(productDB.getDescription()));
        assertTrue(product.getPurchasePrice().setScale(2).equals(productDB.getPurchasePrice()));
        assertTrue(product.getStock() == productDB.getStock());

    }

    private Product makeProduct() {
        final var product = Product.builder()
                .name("Product 1")
                .description("Product 1 description")
                .purchasePrice(BigDecimal.valueOf(100))
                .stock(10).build();

        product.addID(ID);

        return product;
    }
}