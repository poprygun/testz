package io.microsamples.testz.app;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class RootsOfQuadraticEquation {


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
