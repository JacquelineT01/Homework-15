package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverTest {
    @Test
    public void testNoRoots() {
        int result = Solver.solveQuadraticEquations(1.0, 2.0, 3.0);
        assertEquals(0, result);
    }

    @Test
    public void testOneRoot() {
        int result = Solver.solveQuadraticEquations(1.0, -4.0, 4.0);
        assertEquals(1, result);
    }

    @Test
    public void testTwoRoots() {
        int result = Solver.solveQuadraticEquations(1.0, -5.0, 6.0);
        assertEquals(2, result);
    }
}
