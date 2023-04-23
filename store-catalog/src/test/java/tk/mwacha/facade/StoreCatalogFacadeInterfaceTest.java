package tk.mwacha.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Product;
import tk.mwacha.factory.StoreCatalogFacadeFactory;
import tk.mwacha.repository.ProductRepository;
import tk.mwacha.usecase.find.FindProductInputDTO;
import tk.mwacha.usecase.find.FindProductOutputDTO;
import tk.mwacha.usecase.find.FindProductUseCase;
import tk.mwacha.usecase.list.ListProductUseCase;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StoreCatalogFacadeInterfaceTest {

    private static final UUID ID = UUID.randomUUID();

    @Mock
    private ProductRepository repository;

    @Mock
    private FindProductUseCase findProductUseCase;
    @Mock
    private ListProductUseCase listProductUseCase;



    @Test
    void should_find_a_product() {

        final var product = makeProduct();

        try (MockedStatic<StoreCatalogFacadeFactory> utilities = Mockito.mockStatic(StoreCatalogFacadeFactory.class)) {
            utilities.when(StoreCatalogFacadeFactory::create).thenReturn( new StoreCatalogFacade(findProductUseCase, listProductUseCase));
            final var facade = StoreCatalogFacadeFactory.create();
            given(facade.find(new FindProductInputDTO(ID))).willReturn(FindProductOutputDTO.from(product));
            final var result = facade.find(new FindProductInputDTO(ID));

            assertNotNull(result.id());
            assertTrue(result.name().equals(product.getName()));
            assertTrue(result.description().equals(product.getDescription()));
            assertTrue(result.price().equals(product.getPrice()));
        }

    }

    @Test
    void should_find_all_product() {
        final var product = makeProduct();

        try (MockedStatic<StoreCatalogFacadeFactory> utilities = Mockito.mockStatic(StoreCatalogFacadeFactory.class)) {
            utilities.when(StoreCatalogFacadeFactory::create).thenReturn( new StoreCatalogFacade(findProductUseCase, listProductUseCase));
            final var facade = StoreCatalogFacadeFactory.create();
            given(facade.findAll()).willReturn(List.of(product));
            final var result = facade.findAll();

            assertNotNull(result.get(0).getId());
            assertTrue(result.get(0).getName().equals(product.getName()));
            assertTrue(result.get(0).getDescription().equals(product.getDescription()));
            assertTrue(result.get(0).getPrice().equals(product.getPrice()));
        }
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