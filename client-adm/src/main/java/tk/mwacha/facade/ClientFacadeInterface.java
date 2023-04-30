package tk.mwacha.facade;

import tk.mwacha.usecase.addclient.ClientInput;
import tk.mwacha.usecase.findclient.FindClientInput;
import tk.mwacha.usecase.findclient.FindClientOutput;

public interface ClientFacadeInterface {

    FindClientFacadeOutput find(FindClientFacadeInput input);
    AddClientFacadeOutput add(AddClientFacadeInput clientInput);
}
