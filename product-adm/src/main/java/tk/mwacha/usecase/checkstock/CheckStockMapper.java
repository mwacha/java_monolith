package tk.mwacha.usecase.checkstock;

import tk.mwacha.domain.Product;

public final class CheckStockMapper {
    public static CheckStockOutput toOutput(Product product) {
        return new CheckStockOutput(product.getId().getValue(), product.getStock());
    }

}
