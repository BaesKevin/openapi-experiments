package be.kevinbaes.hello_openapi;

import io.specto.hoverfly.junit.core.HoverflyConfig;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.Test;

import static io.specto.hoverfly.junit.core.HoverflyConfig.localConfigs;
import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static io.specto.hoverfly.junit.rule.HoverflyRule.inSimulationMode;
import static org.junit.Assert.assertEquals;

public class HelloServicesTest {

    private static final HoverflyConfig LOCAL_HOVERFLY_CONFIG = localConfigs()
            .proxyLocalHost()
            .proxyPort(8080);
    private static final String HOVERFLY_TARGET_URL = "http://localhost:8080";

    @ClassRule
    public static HoverflyRule HOVERFLY = inSimulationMode(LOCAL_HOVERFLY_CONFIG);

    @Test
    public void shouldReturnApiRespons() {
        HOVERFLY.simulate(dsl(service(HOVERFLY_TARGET_URL)
                .get("/hello/openapi")
                .anyBody()
                .willReturn(success(
                        "Hello openapi!",
                        "text/plain"
                ))
        ));

        HelloServices helloServices = new HelloServices();

        String messages = helloServices.sayHello("openapi");

        assertEquals(messages, "Hello openapi!");
    }

    @Test
    public void shouldEditTemplate() {

    }
}