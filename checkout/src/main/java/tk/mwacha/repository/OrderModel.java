package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "orders")
@Entity(name = "OrderModel")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderModel {
    @Id
    private UUID id;


    private String status;


    private UUID invoiceId;


    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private ClientModel clientModel;

    @OneToMany(mappedBy = "employee")
    private List<ProductModel> products;

}
