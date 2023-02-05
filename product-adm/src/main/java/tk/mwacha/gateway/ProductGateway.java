package tk.mwacha.gateway;

import tk.mwacha.domain.Product;
import tk.mwacha.repository.ProductModel;

public interface ProductGateway {
    void create(Product product);
}
