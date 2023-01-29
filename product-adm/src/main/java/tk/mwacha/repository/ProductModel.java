package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tk.mwacha.usecase.addproduct.AddProductDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
public class ProductModel {

    @Id
    private UUID id;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private int stock;

    private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

    public static ProductModel of(final AddProductDTO dto) {
        return ProductModel.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .purchasePrice(dto.getPurchasePrice())
                .stock(dto.getStock()).build();
    }
}
