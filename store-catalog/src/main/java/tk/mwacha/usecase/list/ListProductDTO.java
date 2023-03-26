package tk.mwacha.usecase.list;

import java.math.BigDecimal;

public record ListProductDTO(
     String name,
     String description,
     BigDecimal price) {

}
