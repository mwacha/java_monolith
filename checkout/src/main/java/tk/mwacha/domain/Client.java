package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.ClientModel;

@AllArgsConstructor
@Getter
@Builder
public class Client extends BaseEntity implements AggregateRoot {
    private String name;
    private String email;
    private String document;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

    public static Client from(final ClientModel clientModel) {
        return Client.builder()
                .name(clientModel.getName())
                .email(clientModel.getEmail())
                .document(clientModel.getDocument())
                .street(clientModel.getStreet())
                .number(clientModel.getNumber())
                .complement(clientModel.getComplement())
                .city(clientModel.getCity())
                .state(clientModel.getState())
                .zipCode(clientModel.getZipCode()).build();
    }

}
