package tk.mwacha.rule;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

//@Slf4j
@Testcontainers
public class PostgresContainer extends PostgreSQLContainer<PostgresContainer> implements BeforeEachCallback {

    private static final String IMAGE_VERSION = "postgres:14.4";
    @Container
    private static PostgresContainer instance;

    public PostgresContainer() {
        super(IMAGE_VERSION);
    }

    private static PostgresContainer getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PostgresContainer();
            instance.withDatabaseName("java_monolith")
                    .withUsername("postgres")
                    .withPassword("postgres")
                    .withExposedPorts(5432);
                    // .withInitScript("DDL.sql")
                    //.withTmpFs(Collections.singletonMap("/var/lib/postgresql/data", "rw"));
            instance.withReuse(true);
            instance.setWaitStrategy(Wait.defaultWaitStrategy()
                    .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS)));
        }
        return instance;
    }
//    @Override
//    protected void waitUntilContainerStarted() {
//        getWaitStrategy().waitUntilReady(instance);
//    }
    @Override
    public void start() {
        super.start();

        System.setProperty("DB_CONTAINER_URL", instance.getJdbcUrl());
        System.setProperty("DB_CONTAINER_PORT", instance.getFirstMappedPort().toString());
        System.setProperty("DB_CONTAINER_USERNAME", instance.getUsername());
        System.setProperty("DB_CONTAINER_PASSWORD", instance.getPassword());
    }

    @Override
    public void stop() {
        //log.info("JVM handles shut down");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        //log.info("JVM handles start");
        getInstance();
        start();
    }
}