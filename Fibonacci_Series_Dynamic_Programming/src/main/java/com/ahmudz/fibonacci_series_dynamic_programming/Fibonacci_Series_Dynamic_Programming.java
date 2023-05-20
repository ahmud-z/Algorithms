package com.ahmudz.fibonacci_series_dynamic_programming;

import java.util.Scanner;

public class Fibonacci_Series_Dynamic_Programming {

    static int findFibo(int n) {

        int fib[] = new int[n];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter no of Fibonacci: ");
        int n = input.nextInt();

        System.out.println(n + " th Fibonacci is: " + findFibo(n)); // 0 1 1 2 3 5 8 13 21 34 55
    }
}
