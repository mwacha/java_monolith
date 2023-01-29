package tk.mwacha.usecase.addproduct;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class AddProductDTO {
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private int stock;
}
