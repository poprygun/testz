package io.microsamples.testz.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@Slf4j
public class RootsOfQuadraticEquationTests {

    @Test
    public void should_calculate_root() throws JsonProcessingException {
        RootsOfQuadraticEquation rootsOfQuadraticEquation
                = new RootsOfQuadraticEquation(2, 6, 4);

        log.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(rootsOfQuadraticEquation));

        assertThat(rootsOfQuadraticEquation.getRoots(), hasItems(-1.0, -2.0));
    }
}
