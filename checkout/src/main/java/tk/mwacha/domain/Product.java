package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.ProductModel;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class Product extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal price;

    public static Product from(final ProductModel model) {
        return Product.builder().name(model.getName())
                .price(model.getPrice())
                .description(model.getDescription()).build();
    }
}
