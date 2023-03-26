package tk.mwacha.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class ProductRepository implements ProductGateway {


    @Override
    public List<Product> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductModel> cq = cb.createQuery(ProductModel.class);
        Root<ProductModel> rootEntry = cq.from(ProductModel.class);
        CriteriaQuery<ProductModel> all = cq.select(rootEntry);
        TypedQuery<ProductModel> allQuery = em.createQuery(all);
        return allQuery.getResultList().stream().map(Product::of).toList();

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
