package tk.mwacha.facade;

import lombok.RequiredArgsConstructor;
import tk.mwacha.usecase.UseCaseInterface;
import tk.mwacha.usecase.addclient.ClientInput;
import tk.mwacha.usecase.addclient.ClientOutput;
import tk.mwacha.usecase.findclient.FindClientInput;
import tk.mwacha.usecase.findclient.FindClientOutput;

@RequiredArgsConstructor
public class ClientFacade implements ClientFacadeInterface {
    private final UseCaseInterface findUseCase;
    private final UseCaseInterface addClientUseCase;

    @Override
    public FindClientFacadeOutput find(FindClientFacadeInput input) {
        return (FindClientFacadeOutput.from((FindClientOutput) this.findUseCase.execute(new FindClientInput(input.id()))));
    }

    @Override
    public AddClientFacadeOutput add(AddClientFacadeInput clientInput) {
        return AddClientFacadeOutput.of((ClientOutput) this.addClientUseCase.execute(ClientInput.of(clientInput)));
    }

}