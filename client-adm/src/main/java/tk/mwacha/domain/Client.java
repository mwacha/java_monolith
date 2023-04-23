package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.ClientModel;
import tk.mwacha.usecase.addclient.ClientInput;

@AllArgsConstructor
@Getter
@Builder
public class Client extends BaseEntity implements AggregateRoot {

    private String name;
    private String email;
    private String address;

    public static Client of(final ClientInput input) {
        return Client.builder()
                .name(input.name())
                .email(input.email())
                .address(input.address()).build();
    }

    public static Client of(final ClientModel model) {
        final var client  = Client.builder()
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress()).build();

        client.addID(model.getId());

        return client;
    }
}
