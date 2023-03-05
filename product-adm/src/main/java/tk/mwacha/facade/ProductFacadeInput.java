package tk.mwacha.facade;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductFacadeInput(String name, String description, BigDecimal purchasePrice, int stock) {
}
