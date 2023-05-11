package com.ahmudz.bubble_sort;

public class Bubble_Sort {

    static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] > arr[i]) {

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void printArray(int arr[]) {

        System.out.print("\nSorted Array: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 10, 22, 6, 6, 1, 0};

        bubbleSort(arr);
        printArray(arr);

    }
}
