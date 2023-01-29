package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.domain.valueobject.Id;
import tk.mwacha.usecase.addproduct.AddProductDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private int stock;

    public static Product of(final AddProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .purchasePrice(dto.getPurchasePrice())
                .stock(dto.getStock()).build();
    }

}
