package io.microsamples.testz.boottestz;

import org.springframework.beans.factory.annotation.Value;

public class MathConfiguration {
    @Value("${var-a}")
    private String varA;

    @Value("${var-b}")
    private String varB;

    @Value("${var-c}")
    private String varC;
}
