package tk.mwacha.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import tk.mwacha.domain.Client;
import tk.mwacha.gateway.ClientGateway;

import java.util.Objects;
import java.util.UUID;

public class ClientRepository implements ClientGateway {

    @Transactional
    public void add(Client client){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final var clientModel = ClientModel.builder()
                .id(client.getId().getValue())
                .name(client.getName())
                .address(client.getAddress())
                .email(client.getEmail())
                .build();

        em.persist(clientModel);
        em.getTransaction().commit();

    }

    public Client find(final UUID id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_monolith");
        EntityManager em = emf.createEntityManager();

        final var client = em.find(ClientModel.class, id);

        if(Objects.isNull(client)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        return Client.of(client);
    }
}
