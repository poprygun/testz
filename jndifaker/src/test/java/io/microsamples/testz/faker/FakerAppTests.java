package io.microsamples.testz.faker;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/application-context.xml"})
@Slf4j
public class FakerAppTests {

    @Autowired
    private ImaginaryDataSource myDataSource;

    @Test
    public void should_load_context_with_mocked_jndi(){
        assertNotNull(myDataSource);
    }
}
