package tk.mwacha.facade;

import tk.mwacha.usecase.addclient.ClientOutput;

import java.time.LocalDateTime;
import java.util.UUID;

public record AddClientFacadeOutput(
        UUID id,
        String name,
        String email,
        String address,
        LocalDateTime cretedAt,
        LocalDateTime updatedAt) {

    public static AddClientFacadeOutput of(final ClientOutput output) {
        return new AddClientFacadeOutput(output.id(), output.name(), output.email(), output.address(), output.createdAt(), output.updatedAt());
    }

}
