package tk.mwacha.gateway;

import tk.mwacha.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {
    List<Product> findAll();

    Product find(UUID id);
}
