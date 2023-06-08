package com.ahmudz.longestcommonsubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    static int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    static int findMaxLength(int arr[][]) {
        int max = -1;

        for (int[] i : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i[j] > max) {
                    max = i[j];
                }
            }
        }

        return max;
    }

    static void printSequence(char arr1[], char arr2[], int LCS[][]) {

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        List<Character> str = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (arr1[i] == arr2[j]) {
                str.add(arr1[i]);
                i--;
                j--;
            } else if (LCS[i - 1][j] > LCS[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        for (int x = 0; x < str.size(); x++) {
            System.out.print(str.get(x) + " ");
        }
        System.out.println("");
    }

    static int findLCS(char arr1[], char arr2[]) {

        int m = arr1.length;
        int n = arr2.length;

        int LCS[][] = new int[m][n];

        if (m == 0 || n == 0) {
            return 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        printSequence(arr1, arr2, LCS);
        return findMaxLength(LCS);
    }

    public static void main(String[] args) {

        String str1 = "BDCB";
        String str2 = "BACDB";

        char arr1[] = new char[str1.length() + 1];
        char arr2[] = new char[str2.length() + 1];

        arr1[0] = '0';
        arr2[0] = '0';

        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = str1.charAt(i - 1);
        }

        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = str2.charAt(i - 1);
        }

        System.out.println("The Longest common sub sequence length is: " + findLCS(arr1, arr2));
    }
}
