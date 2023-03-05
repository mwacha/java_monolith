package tk.mwacha.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tk.mwacha.factory.ProductFacadeFactory;
import tk.mwacha.repository.ProductRepository;
import tk.mwacha.usecase.addproduct.AddProductInputDto;
import tk.mwacha.usecase.checkstock.CheckStockInput;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductFacadeTest {

    private ProductRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ProductRepository();
    }

    @Test
    void should_create_a_product() {

        final var productFacade = ProductFacadeFactory.create();

        final var input = ProductFacadeInput.of(
                "Product 1",
                "Product 1 description",
                BigDecimal.valueOf(100),
                10);

        final var product = productFacade.addProduct(input);

        final var productDB = repository.find(product.id());

//        expect(product).toBeDefined();
//        expect(product.id).toBe(input.id);
//        expect(product.name).toBe(input.name);
//        expect(product.description).toBe(input.description);
//        expect(product.price).toBe(input.price);
//        expect(product.stock).toBe(input.stock);
    }

    @Test
    void should_check_product_stock() {
        final var productFacade = ProductFacadeFactory.create();

        final var input = ProductFacadeInput.of(
                "Product 1",
                "Product 1 description",
                BigDecimal.valueOf(100),
                10);
        final var product = productFacade.addProduct(input);


        final var result = productFacade.checkStock(new CheckStockFacadeInput(product.id()));

//        expect(result.productId).toBe(input.id);
//        expect(result.stock).toBe(input.stock);
    };
}