package tk.mwacha.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "product")
@Entity(name = "ProductModel")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private int stock;

    private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

}
