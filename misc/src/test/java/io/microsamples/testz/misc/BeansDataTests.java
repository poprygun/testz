package io.microsamples.testz.misc;


import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BeansDataTests {

    @Test
    public void should_populate_beans_with_random_data(){
        EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .seed(123L)
                .objectPoolSize(10)
                .randomizationDepth(3)
                .charset(Charset.forName("UTF-8"))
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(false)
                .overrideDefaultInitialization(false)
                .build();

        DataSample hidrated = random.random(DataSample.class);

        log.info(hidrated.toString());
        assertNotNull(hidrated);
        assertNotNull(hidrated.getAddress());
        assertTrue(0 < hidrated.firstName.length());

    }

    @Data
    @NoArgsConstructor
    class DataSample {
        private String firstName;
        private String lastName;
        private Address address;
    }

    @Data
    @NoArgsConstructor
    class Address {
        private String street;
        private String city;
        private String zip;
    }

}
