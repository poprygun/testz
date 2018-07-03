package io.microsamples.testz.misc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class DataSample {
  private String firstName;
  private String lastName;
  private Address address;
}
