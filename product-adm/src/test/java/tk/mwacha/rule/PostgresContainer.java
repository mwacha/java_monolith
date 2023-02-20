package tk.mwacha.rule;

import java.util.Collections;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Slf4j
@Testcontainers
public class PostgresContainer extends PostgreSQLContainer<PostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:14.4";
    @Container
    private static PostgresContainer instance;

    private PostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static PostgresContainer getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PostgresContainer();
            instance.withDatabaseName("java_monolith")
                    .withUsername("postgres")
                    .withPassword("postgres")
                    // .withInitScript("DDL.sql")
                    .withTmpFs(Collections.singletonMap("/var/lib/postgresql/data", "rw"));
            instance.withReuse(true);
        }
        return instance;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_CONTAINER_URL", instance.getJdbcUrl());
        System.setProperty("DB_CONTAINER_USERNAME", instance.getUsername());
        System.setProperty("DB_CONTAINER_PASSWORD", instance.getPassword());
    }

    @Override
    public void stop() {
        log.info("JVM handles shut down");
    }
}