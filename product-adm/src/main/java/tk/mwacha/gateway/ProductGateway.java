package tk.mwacha.gateway;

import tk.mwacha.domain.Product;

import java.util.Optional;

public interface ProductGateway {

    Product add(Product product);
    Optional<Product> find(String id);
}
