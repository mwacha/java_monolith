package tk.mwacha.usecase.checkstock;

import java.util.UUID;

public record CheckStockOutput(UUID productId, int stock) {
}
