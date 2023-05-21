package tk.mwacha.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mwacha.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "products")
@Entity(name = "ProductModel")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel {
    @Id
    private UUID id;

    private String name;

    private String description;


    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private OrderModel order;

    public static ProductModel from(final Product product) {
        return ProductModel.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();

    }
}
