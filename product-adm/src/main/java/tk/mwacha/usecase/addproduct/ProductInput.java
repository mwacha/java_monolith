package tk.mwacha.usecase.addproduct;

import java.math.BigDecimal;

public record ProductInput(
     String name,
     String description,
     BigDecimal purchasePrice,
     int stock) {

    public static ProductInput of(final String name, final String  description, final BigDecimal purchasePrice, final int stock) {
        return new ProductInput(name, description, purchasePrice, stock);
    }

}
