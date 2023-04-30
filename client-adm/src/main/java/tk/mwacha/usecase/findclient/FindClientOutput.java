package tk.mwacha.usecase.findclient;

import tk.mwacha.domain.Client;

import java.time.LocalDateTime;
import java.util.UUID;

public record FindClientOutput(
        UUID id,
        String name,
        String email,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static FindClientOutput from(final Client client) {
        return new FindClientOutput(
                client.getId().getValue(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getCreatedAt(),
                client.getUpdatedAt());
    }

}
