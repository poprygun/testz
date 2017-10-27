package io.microsamples.testz.restassured;

import io.microsamples.testz.app.AlgebraService;
import io.microsamples.testz.app.AppApplication;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.*;

public class FunMathApiTests {

    @Test
    public void should_calculate_roots_of_quadratic_equation(){

        given().standaloneSetup(new AppApplication(). new FunMathApi(new AlgebraService()))
                .params("a", 2, "b", 6, "c", 4)
                .when()
                .get("quadratic")
                .then()
                .assertThat()
                .body("fullForm", is(not(isEmptyString())))
                .body("roots.size()", equalTo(2))
                .body("roots[0]", equalTo(-1.0f))
                .body("roots[1]", equalTo(-2.0f));
    }
}
