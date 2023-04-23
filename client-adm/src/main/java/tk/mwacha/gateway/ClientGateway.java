package tk.mwacha.gateway;

import tk.mwacha.domain.Client;

import java.util.UUID;

public interface ClientGateway {
    void add(Client client);

    Client find(UUID id);
}
