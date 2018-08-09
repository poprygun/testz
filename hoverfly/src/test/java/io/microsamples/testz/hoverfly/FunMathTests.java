package io.microsamples.testz.hoverfly;

import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HoverflyApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunMathTests {

    @Autowired
    TestRestTemplate template;

    // Capture and output HTTP traffic to json file
    // @ClassRule
    // public static HoverflyRule hoverflyRule = HoverflyRule.inCaptureMode("roots.json");

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode(dsl(service("io.microsamples")
            .get("/quadratic").queryParam("a", 2).queryParam("b", 6).queryParam("c", 4)
            .willReturn(success("{\"a\":2,\"b\":6,\"c\":4,\"fullForm\":\"2x² + 6x + 4 = 0\",\"roots\":[-1.0,-2.0]}",
                    "application/json"))))
            .printSimulationData();

    @Test
    public void should_calculate_roots_of_quadratic_equation() throws Exception {

        URI uri = UriComponentsBuilder.fromHttpUrl("http://io.microsamples").path("/quadratic").queryParam("a", 2)
                .queryParam("b", 6).queryParam("c", 4).build().toUri();

        RootsOfQuadraticEquation forObject = template.getForObject(uri, RootsOfQuadraticEquation.class);

        double[] expected = { -1.0d, -2.0d };
        Object[] actual = forObject.getRoots().toArray();

        for (double v : expected) {
            assertThat(actual, hasItemInArray(v));

        }
    }

}
