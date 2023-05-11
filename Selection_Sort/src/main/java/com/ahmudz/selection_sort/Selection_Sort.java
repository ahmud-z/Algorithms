package com.ahmudz.selection_sort;

public class Selection_Sort {

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int small = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[small]) {
                    small = j;
                }
            }

            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int arr[]) {

        System.out.println("\nSorted array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 1, 65, 53, 12, 4, 1, 6, 4, 3, 2, 0, 2, 1, 0};

        selectionSort(arr);
        printArray(arr);
    }
}
