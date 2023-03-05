package tk.mwacha.facade;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductFacadeOutput(UUID id, String name, String description, BigDecimal purchasePrice, int stock) {

    public static ProductFacadeOutput of(final UUID id, final String name, final String  description, final BigDecimal purchasePrice, final int stock) {
        return new ProductFacadeOutput(id, name, description, purchasePrice, stock);
    }
}
