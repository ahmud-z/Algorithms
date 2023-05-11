package com.ahmudz.linear_search;

public class Linear_Search {

    static int linearSearch(int arr[], int searchValue) {

        int flag = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                flag = i;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

        int arr[] = {6, 5, 2, 0, 4, 1, 3};

        int searchValue = 0;

        int temp = linearSearch(arr, searchValue);

        if (temp == -1) {
            System.out.println("\nValue not found");
        } else {
            System.out.println("\nValue found at " + temp + " index position");
        }

    }
}
