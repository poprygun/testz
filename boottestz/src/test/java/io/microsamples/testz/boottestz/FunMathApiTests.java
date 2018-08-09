package io.microsamples.testz.boottestz;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.microsamples.testz.app.AlgebraService;
import io.microsamples.testz.app.AppApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestProcConfig.class, AlgebraService.class })
public class FunMathApiTests {

    private AppApplication.FunMathApi funMathApi;

    private MockMvc mvc;

    @Autowired
    private AlgebraService algebraService;

    @Before
    public void setUp() {

        funMathApi = new AppApplication().new FunMathApi(algebraService);

        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(funMathApi).alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @Test
    public void should_calculate_roots_of_quadratic_equation() throws Exception {

        mvc.perform(
                get("/quadratic").param("a", "2").param("b", "6").param("c", "4").accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("fullForm", equalTo("2x² + 6x + 4 = 0"))).andReturn().getResponse();

    }
}
