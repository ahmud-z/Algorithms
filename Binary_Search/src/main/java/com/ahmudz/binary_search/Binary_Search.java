package com.ahmudz.binary_search;

public class Binary_Search {

    static int binarySearch(int arr[], int left, int right, int searchValue) {
        int mid = (left + right) / 2;

        if (left < right) {

            if (arr[mid] == searchValue) {
                return mid;
            }

            if (searchValue < arr[mid]) {
                return binarySearch(arr, left, mid - 1, searchValue);
            }

            if (searchValue > arr[mid]) {
                return binarySearch(arr, mid + 1, right, searchValue);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchValue = 6;

        int temp = binarySearch(arr, 0, arr.length - 1, searchValue);

        if (temp == -1) {
            System.out.println("\nValue not found");
        } else {
            System.out.println("\nValue found at " + temp + " position");
        }

    }
}
