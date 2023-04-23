package tk.mwacha.facade;

import tk.mwacha.usecase.addclient.ClientInput;
import tk.mwacha.usecase.findclient.FindClientInput;
import tk.mwacha.usecase.findclient.FindClientOutput;

public interface ClientFacadeInterface {

    FindClientOutput find(FindClientInput input);
    void add(ClientInput clientInput);
}
