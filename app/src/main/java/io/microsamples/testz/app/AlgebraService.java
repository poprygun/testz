package io.microsamples.testz.app;

import org.springframework.stereotype.Service;

@Service
public class AlgebraService {

    public RootsOfQuadraticEquation calcSquareRoot(int a, int b, int c) {
        return new RootsOfQuadraticEquation(a, b, c);
    }
}
