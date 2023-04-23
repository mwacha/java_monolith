package tk.mwacha.usecase.addclient;

public record ClientInput(
     String name,
     String email,
     String address) {

    public static ClientInput of(final String name, final String  email, final String address) {
        return new ClientInput(name, email, address);
    }

}
