package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "clients")
@Entity(name = "ClientModel")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientModel implements Serializable {

    @Id
    private UUID id;

    private String name;
    private String email;

    private String  document;
    private String street;

    private String number;

    private String complement;

    private String city;

    private String state;

    private String zipCode;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private OrderModel order;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
