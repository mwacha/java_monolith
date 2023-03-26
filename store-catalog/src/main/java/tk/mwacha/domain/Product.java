package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

    public static Product of(final ProductModel model) {
        final var product  = Product.builder()
                .name(model.getName())
                .description(model.getDescription())
                .price(model.getPurchasePrice()).build();

        product.addID(model.getId());

        return product;
    }
}
