package tk.mwacha.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import tk.mwacha.context.ContextTestRepository;

@Sql(scripts = {"classpath:/script_sql/clean-data.sql", "classpath:/script_sql/create-product.sql"})
class ProductRepositoryTest extends ContextTestRepository {

        private static final long DEFAULT_TENANT_ID = 1;
        @Autowired
        private ProductRepository repository;

       // TODO Criar a pasta e script sql
}