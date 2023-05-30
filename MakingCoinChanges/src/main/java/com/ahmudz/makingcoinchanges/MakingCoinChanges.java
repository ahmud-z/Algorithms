package com.ahmudz.makingcoinchanges;

public class MakingCoinChanges {

    static int findCoin(int coins[], int amount) {
        int maxCoin = coins[0];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > maxCoin && coins[i] <= amount) {
                maxCoin = coins[i];
            }
        }
        return maxCoin;
    }

    static int findTotalCoin(int amount) {

        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int total = 0;

        System.out.print("Taken coins: ");
        while (amount > 0) {
            int maxCoin = findCoin(coins, amount);
            System.out.print(maxCoin + " ");
            int num = amount / maxCoin;
            amount = amount - (num * maxCoin);
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        int amount = 16;

        System.out.println("\nTotal required coins: " + MakingCoinChanges.findTotalCoin(amount));
    }
}
