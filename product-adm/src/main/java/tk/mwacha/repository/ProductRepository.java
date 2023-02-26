package tk.mwacha.repository;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.util.Objects;
import java.util.UUID;

@Transactional
public class ProductRepository implements ProductGateway {
    public void add(Product product){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final var productModel = ProductModel.builder()
                .id(product.getId().getValue())
                .name(product.getName())
                .description(product.getDescription())
                .purchasePrice(product.getPurchasePrice())
                .stock(product.getStock())
                .build();

        em.persist(productModel);
        em.getTransaction().commit();

    }

    public Product find(final UUID id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();

        final var product = em.find(ProductModel.class, id);

        if(Objects.isNull(product)) {
            throw new RuntimeException("Produto não encontrado");
        }

        return Product.of(product);
    }
}
