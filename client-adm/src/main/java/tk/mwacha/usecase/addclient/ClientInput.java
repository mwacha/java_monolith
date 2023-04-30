package tk.mwacha.usecase.addclient;

import tk.mwacha.facade.AddClientFacadeInput;

public record ClientInput(
     String name,
     String email,
     String address) {

    public static ClientInput of(final String name, final String  email, final String address) {
        return new ClientInput(name, email, address);
    }
    public static ClientInput of(final AddClientFacadeInput input) {
        return new ClientInput(input.name(), input.email(), input.address());
    }


}
