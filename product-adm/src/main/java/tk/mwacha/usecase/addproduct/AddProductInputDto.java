package tk.mwacha.usecase.addproduct;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public record AddProductInputDto (
     String name,
     String description,
     BigDecimal purchasePrice,
     int stock) {

    public static AddProductInputDto of(final String name, final String  description,  final BigDecimal purchasePrice, final int stock) {
        return new AddProductInputDto(name, description, purchasePrice, stock);
    }
}
