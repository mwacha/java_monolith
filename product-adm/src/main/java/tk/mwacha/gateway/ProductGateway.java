package tk.mwacha.gateway;

import tk.mwacha.domain.Product;

import java.util.UUID;

public interface ProductGateway {
    void add(Product product);

    Product find(UUID id);
}
