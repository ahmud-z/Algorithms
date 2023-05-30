package com.ahmudz.longestincreasingsubsequence;

public class LongestIncreasingSubsequence {

    static int[] findSubsequnce(int arr[]) {

        int lis[] = new int[arr.length];
        int prev[] = new int[arr.length];

        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
            prev[i] = 0;
        }

        lis[0] = 0;
        prev[0] = -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
        }

        System.out.print("Parents: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(prev[i] + " ");
        }
        return lis;
    }

    public static void main(String[] args) {

        int arr[] = {0, 9, 2, 5, 3, 7, 11, 8, 10, 13, 6};

        int lis[] = findSubsequnce(arr);

        int max = lis[0];
        System.out.println("");
        for (int i = 0; i < lis.length; i++) {
            System.out.print(lis[i] + " ");
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        System.out.println("\nMax: " + max);
    }
}
