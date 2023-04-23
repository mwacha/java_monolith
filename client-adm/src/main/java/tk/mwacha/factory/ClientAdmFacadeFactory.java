package tk.mwacha.factory;

import tk.mwacha.facade.ClientFacade;
import tk.mwacha.repository.ClientRepository;
import tk.mwacha.usecase.addclient.AddClientUseCase;
import tk.mwacha.usecase.findclient.FindClientUseCase;

public final class ClientAdmFacadeFactory {

    public static ClientFacade create()  {
        final var clientRepository = new ClientRepository();
        final var findClientUseCase = new FindClientUseCase(clientRepository);
        final var addClient = new AddClientUseCase(clientRepository);
        return  new ClientFacade(findClientUseCase, addClient);
    }
}
