package com.ahmudz.fibonacci_series_dynamic_programming;

public class Fibonacci_Series_Dynamic_Programming {

    public static void main(String[] args) {

        int term1 = 0;
        int term2 = 1;
        int nextTerm = term1 + term2;

        System.out.print("" + term1 + " " + term2 + " ");

        for (int i = 2; i <= 10; i++) {

            System.out.print(nextTerm + " ");
            term1 = term2;
            term2 = nextTerm;
            nextTerm = term1 + term2;
        }

    }
}
