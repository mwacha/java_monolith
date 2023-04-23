package tk.mwacha.repository;

import org.junit.jupiter.api.*;
import tk.mwacha.domain.Client;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientRepositoryTest {

    private static final UUID ID = UUID.randomUUID();

    private ClientRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ClientRepository();
    }

    @Test
    @Order(1)
    void should_add_client() {

        final var client = makeClient();

        repository.add(client);

        final var clientDB = repository.find(client.getId().getValue());

        assertNotNull(clientDB);
        assertTrue(client.getId().getValue().equals(clientDB.getId().getValue()));
        assertTrue(client.getName().equals(clientDB.getName()));
        assertTrue(client.getEmail().equals(clientDB.getEmail()));
        assertTrue(client.getAddress().equals(clientDB.getAddress()));

    }

    @Test
    @Order(2)
    void should_find() {
        final var client = makeClient();

        final var clientDB = repository.find(client.getId().getValue());

        assertNotNull(clientDB);
        assertTrue(client.getId().getValue().equals(clientDB.getId().getValue()));
        assertTrue(client.getName().equals(clientDB.getName()));
        assertTrue(client.getEmail().equals(clientDB.getEmail()));
        assertTrue(client.getAddress().equals(clientDB.getAddress()));

    }

    private Client makeClient() {
        final var client = Client.builder()
                .name("Client 1")
                .email("client@test.com")
                .address("rua tal 1").build();

        client.addID(ID);

        return client;
    }
}