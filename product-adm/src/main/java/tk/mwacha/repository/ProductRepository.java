package tk.mwacha.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductModel, UUID> {
}
