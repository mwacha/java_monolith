package tk.mwacha.usecase.findclient;

import tk.mwacha.domain.Client;

import java.util.UUID;

public record FindClientOutput(
        UUID id,
        String name,
        String email,
        String address) {

    public static FindClientOutput from(final Client client) {
        return new FindClientOutput(
                client.getId().getValue(),
                client.getName(),
                client.getEmail(),
                client.getAddress());
    }

}
