package com.ahmudz.quick_sort;

public class Quick_Sort {

    static int partition(int arr[], int left, int right) {
        int pivot = left;
        int minIndex = left + 1;
        int maxIndex = right;

        while (minIndex <= maxIndex) {

            while (maxIndex >= minIndex && arr[minIndex] <= arr[pivot]) {
                minIndex++;
            }

            while (maxIndex >= minIndex && arr[maxIndex] > arr[pivot]) {
                maxIndex--;
            }

            if (maxIndex >= minIndex) {

                int temp = arr[maxIndex];
                arr[maxIndex] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[maxIndex];
        arr[maxIndex] = temp;

        return maxIndex;
    }

    static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            int pivot_loc = partition(arr, left, right);

            quickSort(arr, left, pivot_loc - 1);

            quickSort(arr, pivot_loc + 1, right);

        }
    }

    static void printArray(int arr[]) {

        System.out.println("\nsorted array elements: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) {

        int arr[] = {5, 3, 4, 3, 1, 6, 4, 6, 0, 1, 2, 0};

        quickSort(arr, 0, arr.length - 1);

        printArray(arr);
    }
}
