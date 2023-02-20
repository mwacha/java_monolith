package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import tk.mwacha.usecase.addproduct.AddProductInputDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    @Id
    private UUID id;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private int stock;

    private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

}
