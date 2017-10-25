package io.microsamples.testz.app;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RestController
    public class FunMathApi {

        @GetMapping(value = "quadratic", produces = "application/json")
        public ResponseEntity<RootsOfQuadraticEquation> roots(@RequestParam("a") int a
                , @RequestParam("b") int b
                , @RequestParam("c") int c) {

            return new ResponseEntity<RootsOfQuadraticEquation>(new RootsOfQuadraticEquation(a, b, c), HttpStatus.OK);
        }
    }


    @Getter
    class RootsOfQuadraticEquation {

        public RootsOfQuadraticEquation(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;

            double temp1 = Math.sqrt(b * b - 4 * a * c);

            double root1 = (-b + temp1) / (2 * a);
            double root2 = (-b - temp1) / (2 * a);

            fullForm = String.valueOf(a) + "x" + '\u00B2'
                    + " + " + String.valueOf(b) + "x"
                    + " + " + String.valueOf(c)
                    + " = 0";

            roots = Arrays.asList(root1, root2);
        }

        private  int a;
        private  int b;
        private  int c;
        private String fullForm;
        private List roots;

    }
}
