package tk.mwacha.facade;

import tk.mwacha.domain.Client;
import tk.mwacha.usecase.findclient.FindClientOutput;

import java.time.LocalDateTime;
import java.util.UUID;

public record FindClientFacadeOutput(
        UUID id,
        String name,
        String email,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static FindClientFacadeOutput from(final FindClientOutput client) {
        return new FindClientFacadeOutput(
                client.id(),
                client.name(),
                client.email(),
                client.address(),
                client.createdAt(),
                client.updatedAt());
    }

}
