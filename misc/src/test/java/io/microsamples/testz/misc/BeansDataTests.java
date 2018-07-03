package io.microsamples.testz.misc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class BeansDataTests {

  @Mock private SomeService someService;

  private EnhancedRandom random =
      EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
          .seed(123L)
          .objectPoolSize(10)
          .randomizationDepth(3)
          .charset(Charset.forName("UTF-8"))
          .stringLengthRange(5, 50)
          .collectionSizeRange(1, 10)
          .scanClasspathForConcreteTypes(false)
          .overrideDefaultInitialization(false)
          .build();

  @Test
  public void should_user_proper_parameter() {
    ArgumentCaptor<DataSample> captor = ArgumentCaptor.forClass(DataSample.class);
    DataSample expected = random.random(DataSample.class);

    someService.executeMe(expected);

    verify(someService).executeMe(captor.capture());
    assertThat(captor.getValue(), samePropertyValuesAs(expected));
  }

  @Test
  public void should_populate_beans_with_random_data() {

    DataSample hidrated = random.random(DataSample.class);

    log.info(hidrated.toString());
    assertNotNull(hidrated);
    assertNotNull(hidrated.getAddress());
    assertTrue(0 < hidrated.getFirstName().length());
  }
}
