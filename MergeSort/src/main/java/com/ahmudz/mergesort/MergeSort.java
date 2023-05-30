package com.ahmudz.mergesort;

public class MergeSort {

    static void merge(int arr[], int left, int mid, int right) {

        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize) { //Copying reamins element from leftarray
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {    // Copying reamins element from right array
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }

    static void mergeSort(int arr[], int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = {7, 5, 1, 41, 0, 21, 2, 10};

        MergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array elements: ");
        MergeSort.printArray(arr);
    }
}
