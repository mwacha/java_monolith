package tk.mwacha.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import tk.mwacha.domain.Order;
import tk.mwacha.gateway.CheckoutGateway;

import java.util.Objects;
import java.util.UUID;

public class OrderRepository implements CheckoutGateway {

    @Transactional
    public void addOrder(Order order){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        final var clientModel = ClientModel.builder()
                .id(order.getClient().getId().getValue())
                .name(order.getClient().getName())
                .email(order.getClient().getEmail())
                .build();

        final var orderModel = OrderModel.builder()
                .id(order.getId().getValue())
                .clientModel(clientModel)
                .status(order.getStatus())
                .invoiceId(order.getInvoiceId())
                .products(order.getProducts().stream().map(ProductModel::from).toList())
                .build();

        em.persist(orderModel);
        em.getTransaction().commit();

    }

    public Order findOrder(final UUID id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();

        final var order = em.find(OrderModel.class, id);

        if(Objects.isNull(order)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        return Order.of(order);
    }
}
