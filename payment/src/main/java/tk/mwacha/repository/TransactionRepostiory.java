package tk.mwacha.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import tk.mwacha.domain.Transaction;
import tk.mwacha.gateway.PaymentGateway;


public class TransactionRepostiory implements PaymentGateway {

    @Transactional
    @Override
    public Transaction save(Transaction transaction){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final var transactionModel = TransactionModel.builder()
                .id(transaction.getId().getValue())
                .orderId(transaction.getOrderId())
                .status(transaction.getStatus())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();

        em.persist(transactionModel);
        em.getTransaction().commit();

        return Transaction.of(transactionModel);
    }
}
