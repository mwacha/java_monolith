package tk.mwacha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tk.mwacha.domain.entity.AggregateRoot;
import tk.mwacha.domain.entity.BaseEntity;
import tk.mwacha.repository.ProductModel;
import tk.mwacha.usecase.addproduct.ProductInput;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private int stock;

    public static Product of(final ProductInput dto) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .purchasePrice(dto.purchasePrice())
                .stock(dto.stock()).build();
    }

    public static Product of(final ProductModel model) {
        final var product  = Product.builder()
                .name(model.getName())
                .description(model.getDescription())
                .purchasePrice(model.getPurchasePrice())
                .stock(model.getStock()).build();

        product.addID(model.getId());

        return product;
    }
}
