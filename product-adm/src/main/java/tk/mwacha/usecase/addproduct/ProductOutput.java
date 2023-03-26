package tk.mwacha.usecase.addproduct;

import tk.mwacha.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductOutput(
     UUID id,
     String name,
     String description,
     BigDecimal purchasePrice,
     int stock,
     LocalDateTime createdAt,
     LocalDateTime updatedAt) {

    public static ProductOutput from(final Product product) {
        return new ProductOutput(
                product.getId().getValue(),
                product.getName(),
                product.getDescription(),
                product.getPurchasePrice(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt());
    }

}
