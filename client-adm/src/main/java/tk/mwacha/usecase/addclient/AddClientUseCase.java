package tk.mwacha.usecase.addclient;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Client;
import tk.mwacha.gateway.ClientGateway;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class AddClientUseCase implements UseCaseInterface<ClientInput, ClientOutput> {

    private final ClientGateway clienttGateway;

    public ClientOutput execute(ClientInput input) {
        final var client = Client.of(input);

        client.generateID();
        clienttGateway.add(client);

        return ClientOutput.from(client);

    }
}
