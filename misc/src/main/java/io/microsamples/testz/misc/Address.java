package io.microsamples.testz.misc;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String zip;
}
