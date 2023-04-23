package tk.mwacha.usecase.find;

import tk.mwacha.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

public record FindProductOutputDTO(
        UUID id,
        String name,
        String description,
        BigDecimal price) {

    public static FindProductOutputDTO from(final Product product) {
        return new FindProductOutputDTO(
                product.getId().getValue(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

}
