package io.microsamples.testz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RestController
    public class FunMathApi {

        private AlgebraService algebraService;

        public FunMathApi(AlgebraService algebraService) {
            this.algebraService = algebraService;
        }

        @GetMapping(value = "quadratic", produces = "application/json")
        public ResponseEntity<RootsOfQuadraticEquation> roots(@RequestParam("a") int a, @RequestParam("b") int b,
                @RequestParam("c") int c) {

            return new ResponseEntity<>(new RootsOfQuadraticEquation(a, b, c), HttpStatus.OK);
        }
    }
}
