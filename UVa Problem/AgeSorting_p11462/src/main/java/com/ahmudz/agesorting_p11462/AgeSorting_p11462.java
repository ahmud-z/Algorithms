package com.ahmudz.agesorting_p11462;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AgeSorting_p11462 {

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

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }

    static void readData() throws FileNotFoundException {

        File filePath = new File("C:/Users/Mahmud/Desktop/AgeSortData.txt");
        Scanner file = new Scanner(filePath);

        List<int[]> dataset = new ArrayList<>();

        while (true) {
            int n = file.nextInt();

            if (n == 0) {
                break;
            }

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = file.nextInt();
            }

            dataset.add(arr);
        }

        for (int i = 0; i < dataset.size(); i++) {

            int tempArr[] = dataset.get(i);
            quickSort(tempArr, 0, tempArr.length - 1);
            printArray(tempArr);
        }
    }

    public static void main(String[] args) {
        try {
            readData();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
