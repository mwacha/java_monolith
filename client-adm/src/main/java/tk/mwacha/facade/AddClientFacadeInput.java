package tk.mwacha.facade;

public record AddClientFacadeInput(
     String name,
     String email,
     String address) {

    public static AddClientFacadeInput of(final String name, final String  email, final String address) {
        return new AddClientFacadeInput(name, email, address);
    }

}
