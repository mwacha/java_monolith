package tk.mwacha.usecase.findclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.domain.Client;
import tk.mwacha.gateway.ClientGateway;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FindClientUseCaseTest {

    @Mock
    private ClientGateway gateway;

    @InjectMocks
    private FindClientUseCase useCase;

    @Test
    void should_find() {

        final var client = makeClient();
        given(gateway.find(client.getId().getValue()))
                .willReturn(client);

        final var result =  useCase.execute(new FindClientInput(client.getId().getValue()));

        assertNotNull(result);
        assertTrue(result.id().equals(client.getId().getValue()));
        assertTrue(result.name().equals(client.getName()));
        assertTrue(result.email().equals(client.getEmail()));
        assertTrue(result.address().equals(client.getAddress()));


    }
    private Client makeClient() {
        final var client = Client.builder()
                .name("Client 1")
                .email("client@test.com")
                .address("rua tal 1").build();

        client.addID(UUID.randomUUID());

        return client;
    }
}