package tk.mwacha.facade;

import java.util.UUID;

public record CheckStockFacadeOutput(UUID productId, int stock) {
}
