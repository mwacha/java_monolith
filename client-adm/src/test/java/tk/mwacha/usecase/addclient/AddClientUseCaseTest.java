package tk.mwacha.usecase.addclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tk.mwacha.gateway.ClientGateway;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    @Mock
    private ClientGateway gateway;
    @InjectMocks
    private AddClientUseCase useCase;

    @Test
    void should_add_client() {
        final var input = ClientInput.of(
                "Client 1",
                "client@email.com",
                "rua tal");

        final var result = useCase.execute(input);

        verify(gateway, times(1)).add(any());


        assertNotNull(result.id());
        assertTrue(result.name().equals(input.name()));
        assertTrue(result.email().equals(input.email()));
        assertTrue(result.address().equals(input.address()));
    }
}