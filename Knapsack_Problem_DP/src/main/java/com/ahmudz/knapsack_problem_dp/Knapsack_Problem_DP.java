package com.ahmudz.knapsack_problem_dp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Knapsack_Problem_DP {

    static int findMaximumProfits(int a, int b) {
        return a > b ? a : b;                       // returns max items
    }

    static int findKnapsack(int knapsackCapacity, int itemWeights[], int itemValues[], int numberOfItem) {

        int P[][] = new int[numberOfItem + 1][knapsackCapacity + 1];

        for (int i = 0; i <= numberOfItem; i++) {

            for (int j = 0; j <= knapsackCapacity; j++) {
                if (i == 0 || j == 0) {
                    P[i][j] = 0;                        // initially sets all 0 row-col value is 0
                } else if (itemWeights[i - 1] <= j) {
                    P[i][j] = findMaximumProfits(itemValues[i - 1] + P[i - 1][j - itemWeights[i - 1]], P[i - 1][j]);  // DP formula for knapsack 
                } else {                                                                                             // P[i][w] = max(val[i − 1] + P[i − 1][w − wt[i − 1]], P[i − 1][w]);
                    P[i][j] = P[i - 1][j];
                }
            }
        }

        for (int i = 0; i < numberOfItem + 1; i++) {
            for (int j = 0; j < knapsackCapacity + 1; j++) {
                System.out.print(P[i][j] + " ");
            }
            System.out.println(" ");
        }

        return P[numberOfItem][knapsackCapacity];
    }

    static void readFile() throws FileNotFoundException {
        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\Algorithms\\knapsack_items.txt");
        Scanner file = new Scanner(filePath);

        int numberOfItems = file.nextInt();
        int knapsackCapacity = file.nextInt();

        int itemValues[] = new int[numberOfItems];
        int itemsWeights[] = new int[numberOfItems];

        int temp = 0;

        while (file.hasNext()) {
            int i = file.nextInt();
            int j = file.nextInt();

            itemValues[temp] = i;
            itemsWeights[temp] = j;
            temp++;
        }

        System.out.println("Maximum profits: " + findKnapsack(knapsackCapacity, itemsWeights, itemValues, numberOfItems));
    }

    public static void main(String[] args) {

        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
