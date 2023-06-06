package com.ahmudz.longestincreasingsubsequence_dp;

public class LongestIncreasingSubsequence_DP {

    static void printSequence(int arr[], int lengthArr[], int prevArr[]) {
        int maxLength = 0;
        int maxIndex = 0;

        for (int i = 0; i < lengthArr.length; i++) {
            if (lengthArr[i] > maxLength) {
                maxLength = lengthArr[i];
                maxIndex = i;
            }
        }

        int[] subsequence = new int[maxLength];
        int currentIndex = maxIndex;
        int subseqIndex = maxLength - 1;

        while (currentIndex > 0) {
            subsequence[subseqIndex] = arr[currentIndex];
            currentIndex = prevArr[currentIndex];
            subseqIndex--;
        }

        System.out.print("The Longest Increasing Subsequence is: ");
        for (int i = 0; i < subsequence.length; i++) {
            System.out.print(subsequence[i] + " ");
        }
        System.out.println();
    }

    static int findMaxLength(int arr[]) {
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void findLIS(int arr[]) {

        int LIS[] = new int[arr.length + 1];
        int prev[] = new int[arr.length + 1];

        for (int i = 0; i < LIS.length; i++) {
            LIS[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int result = findMaxLength(LIS);
        System.out.println("\nLongest subsequence length is: " + result);

        printSequence(arr, LIS, prev);
    }

    public static void main(String[] args) {
        int arr[] = {9, 2, 5, 3, 7, 11, 8, 10, 13, 6};

        findLIS(arr);
    }
}
