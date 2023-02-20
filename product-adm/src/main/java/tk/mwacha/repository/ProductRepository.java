package tk.mwacha.repository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;

import java.util.UUID;

public class ProductRepository implements ProductGateway {
    public void add(Product product){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("INSERT INTO Product (id, name, description, purchasePrice, stock) values (:id, :name, :description, :purchasePrice, stock)")
                .setParameter("id", product.getId())
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("purchasePrice", product.getPurchasePrice())
                .setParameter("stock", product.getStock())
                .executeUpdate();
        em.getTransaction().commit();
    }

    public Product find(final UUID id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Product p", Product.class).getSingleResult();
    }
}
