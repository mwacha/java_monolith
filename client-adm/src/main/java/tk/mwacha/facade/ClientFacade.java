package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.usecase.addclient.AddClientUseCase;
import tk.mwacha.usecase.addclient.ClientInput;
import tk.mwacha.usecase.findclient.FindClientInput;
import tk.mwacha.usecase.findclient.FindClientOutput;
import tk.mwacha.usecase.findclient.FindClientUseCase;

@RequiredArgsConstructor
public class ClientFacade implements ClientFacadeInterface {
    private final FindClientUseCase findUseCase;
    private final AddClientUseCase addClientUseCase;

    @Override
    public FindClientOutput find(FindClientInput input) {
        return this.findUseCase.execute(input);
    }

    public void add(final ClientInput client) {
        this.addClientUseCase.execute(client);
    }
}