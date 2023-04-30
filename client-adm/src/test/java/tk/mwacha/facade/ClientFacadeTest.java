package tk.mwacha.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tk.mwacha.factory.ClientAdmFacadeFactory;
import tk.mwacha.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientFacadeTest {
    private ClientRepository repository;

    @BeforeEach
    void setup() {
        this.repository = new ClientRepository();
    }

    @Test
    void should_create_a_client() {

        final var clientFacade = ClientAdmFacadeFactory.create();

        final var input = AddClientFacadeInput.of(
                "Client 1",
                "teste@tes.com",
               "rua tal");

       final var output = clientFacade.add(input);

        final var clientDB = repository.find(output.id());

        assertNotNull(output.id());
        assertTrue(output.name().equals(clientDB.getName()));
        assertTrue(output.email().equals(clientDB.getEmail()));
        assertTrue(output.address().equals(clientDB.getAddress()));

    }

    @Test
    void should_find_a_client() {
        final var clientFacade = ClientAdmFacadeFactory.create();


        final var input = AddClientFacadeInput.of(
                "Client 1",
                "teste@tes.com",
                "rua tal");

        final var output = clientFacade.add(input);

        final var client = clientFacade.find(new FindClientFacadeInput(output.id()));

        assertNotNull(client);
        assertTrue(output.id().equals(client.id()));
        assertTrue(output.name().equals(client.name()));
        assertTrue(output.email().equals(client.email()));
        assertTrue(output.address().equals(client.address()));
    }

}