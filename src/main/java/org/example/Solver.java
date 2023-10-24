package org.example;

public class Solver {
    //Task 3.1
    public static int solveQuadraticEquations(double a, double b, double c) {
        double D = b * b - 4 * a * c;

        if (D < 0) {
            return 0;
        } else if (D == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
