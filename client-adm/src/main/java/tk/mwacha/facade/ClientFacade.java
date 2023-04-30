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
    public FindClientFacadeOutput find(FindClientFacadeInput input) {
        return FindClientFacadeOutput.from(this.findUseCase.execute(new FindClientInput(input.id())));
    }

    @Override
    public AddClientFacadeOutput add(AddClientFacadeInput clientInput) {
        return AddClientFacadeOutput.of(this.addClientUseCase.execute(ClientInput.of(clientInput)));
    }

}