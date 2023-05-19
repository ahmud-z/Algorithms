package com.ahmudz.fractional_knapsack_algorithm;

import java.util.Arrays;
import java.util.Comparator;

class Sort_By_Profit implements Comparator<Items> {

    @Override
    public int compare(Items ob1, Items ob2) {

        int n1 = ob1.profit / ob1.weight;
        int n2 = ob2.profit / ob2.weight;

        if (n1 < n2) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Items {

    int id;
    int weight;
    int profit;

    public Items(int id, int profit, int weight) {

        this.id = id;
        this.profit = profit;
        this.weight = weight;
    }
}

public class Fractional_Knapsack_Algorithm {

    static double findKnapsack(Items arr[], int capcity) {

        Arrays.sort(arr, new Sort_By_Profit());

        double totalProfits = 0d;

        for (Items i : arr) {
            int currentWeight = i.weight;
            int currentProfits = i.profit;

            if (capcity - currentWeight >= 0) {
                totalProfits += currentProfits;
                capcity -= currentWeight;
                System.out.println("Taken product id: "+i.id);  
            } else {

                double fractionWeight = ((double) capcity / (double) currentWeight);

                totalProfits += (int) (currentProfits * fractionWeight);
                capcity = (int) (capcity - (currentWeight * fractionWeight));
                System.out.println("Taken product id: "+i.id);
                break;
            }
        }

        System.out.println("\nRemained Capacity: " + capcity);
        return totalProfits;
    }

    public static void main(String[] args) {

        Items[] arr = {
            new Items(1, 12, 4),
            new Items(2, 32, 8),
            new Items(3, 40, 2),
            new Items(4, 30, 6),
            new Items(5, 50, 1)
        };

        int capacity = 10;

        double totalProfits = findKnapsack(arr, capacity);

        System.out.println("Profits: " + totalProfits);
    }
}
