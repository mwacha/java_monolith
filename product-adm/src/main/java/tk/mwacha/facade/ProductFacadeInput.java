package tk.mwacha.facade;

import tk.mwacha.usecase.addproduct.AddProductInputDto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductFacadeInput(String name, String description, BigDecimal purchasePrice, int stock) {

    public static ProductFacadeInput of(final String name, final String  description, final BigDecimal purchasePrice, final int stock) {
        return new ProductFacadeInput(name, description, purchasePrice, stock);
    }
}
