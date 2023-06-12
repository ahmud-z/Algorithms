package com.ahmudz.coinchangecombinationproblem;

import java.util.Scanner;

public class CoinChangeCombinationProblem {

    static int findMax(int arr[]) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int coinChange(int moneyAmount, int[] coins) {
        int combinationArray[] = new int[moneyAmount + 1];
        combinationArray[0] = 1;

        for (int i : coins) {
            for (int j = i; j <= moneyAmount; j++) {
                combinationArray[j] += combinationArray[j - i];
            }
        }

        return findMax(combinationArray);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int coins[] = {1, 5, 10};

        System.out.print("Enter your amount: ");
        int moneyAmount = input.nextInt();

        int maxCombination = coinChange(moneyAmount, coins);

        System.out.println("Possible coin change combination is: " + maxCombination);   //for 10 possible combinations: {(10),(5+5),(5+1+1+1+1+1),(1+1+1+1+1+1+1+1+1+1)
    }
}
