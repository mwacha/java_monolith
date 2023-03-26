package tk.mwacha.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tk.mwacha.factory.ProductFacadeFactory;
import tk.mwacha.repository.ProductRepository;
import tk.mwacha.usecase.addproduct.ProductInput;
import tk.mwacha.usecase.checkstock.CheckStockInput;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductFacadeTest {

    private ProductRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ProductRepository();
    }

    @Test
    void should_create_a_product() {

        final var productFacade = ProductFacadeFactory.create();

        final var input = ProductInput.of(
                "Product 1",
                "Product 1 description",
                BigDecimal.valueOf(100),
                10);

        final var product = productFacade.addProduct(input);

        final var productDB = repository.find(product.id());

        assertNotNull(product.id());
        assertTrue(product.name().equals(productDB.getName()));
        assertTrue(product.description().equals(productDB.getDescription()));
        assertTrue(product.purchasePrice().setScale(2).equals(productDB.getPurchasePrice()));
        assertTrue(product.stock() == productDB.getStock());

    }

    @Test
    void should_check_product_stock() {
        final var productFacade = ProductFacadeFactory.create();

        final var input = ProductInput.of(
                "Product 1",
                "Product 1 description",
                BigDecimal.valueOf(100),
                10);
        final var product = productFacade.addProduct(input);


        final var result = productFacade.checkStock(new CheckStockInput(product.id()));

        assertTrue(result.productId().equals(product.id()));
        assertTrue(result.stock() == product.stock());
    };
}