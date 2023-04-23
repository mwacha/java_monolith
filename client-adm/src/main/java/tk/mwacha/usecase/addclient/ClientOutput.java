package tk.mwacha.usecase.addclient;

import tk.mwacha.domain.Client;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientOutput(
     UUID id,
     String name,
     String email,
     String address,
     LocalDateTime createdAt,
     LocalDateTime updatedAt) {

    public static ClientOutput from(final Client client) {
        return new ClientOutput(
                client.getId().getValue(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getCreatedAt(),
                client.getUpdatedAt());
    }

}
