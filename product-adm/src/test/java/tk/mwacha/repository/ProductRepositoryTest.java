package tk.mwacha.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import tk.mwacha.context.ContextTestRepository;

@Sql(scripts = {"classpath:/script_sql/clean-data.sql", "classpath:/script_sql/create-product.sql"})
class ProductRepositoryTest extends ContextTestRepository {

        @Autowired
        private ProductRepository repository;

       // Criar a pasta e script sql
    @Test
    void should_create() {
        Assertions.assertTrue(true);
    }
}