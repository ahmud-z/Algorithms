package com.ahmudz.topological_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class DFS {

    static int nodeAmount;
    static int color[];
    static int discoveryTime[];
    static int finishTime[];
    static int time;
    static List<Integer> sortedNodes;

    static Stack<String> topoStack = new Stack<>();

    static void init(int graph[][]) {
        nodeAmount = graph.length;
        color = new int[nodeAmount];
        sortedNodes = new ArrayList<>();

        discoveryTime = new int[nodeAmount];
        finishTime = new int[nodeAmount];

        for (int i = 0; i < nodeAmount; i++) {
            color[i] = 0;
            discoveryTime[i] = Integer.MAX_VALUE;
            finishTime[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nodeAmount; i++) {
            if (color[i] == 0) {
                runDFS(graph, i);
            }
        }

        for (int i = 0; i < sortedNodes.size(); i++) {
            Integer get = sortedNodes.get(i);
            System.out.print(get + " ");
        }
        System.out.println("");
        for (int i = sortedNodes.size() - 1; i >= 0; i--) {
            Integer get = sortedNodes.get(i);
            System.out.print(get + " ");
        }
    }

    static void runDFS(int graph[][], int u) {

        color[u] = 1;
        time++;
        discoveryTime[u] = time;

        for (int v = 1; v < nodeAmount; v++) {
            if (graph[u][v] == 1 && color[v] == 0) {
                runDFS(graph, v);
            }
        }

        sortedNodes.add(u);
        color[u] = 2;
        time++;
        finishTime[u] = time;
    }
}

public class Topological_Sort {

    static int[][] readFile() throws FileNotFoundException {

        File filePath = new File("C:/Users/Mahmud/Desktop/10305.txt");

        Scanner file = new Scanner(filePath);

        int node = file.nextInt();
        int edge = file.nextInt();

        int adjMatrix[][] = new int[node][node];

        while (file.hasNext()) {
            int i = file.nextInt();
            int j = file.nextInt();

            adjMatrix[i-1][j-1] = 1;        // Directed Graph
        }

        for (int i = 0; i < adjMatrix.length; i++) {
            int[] is = adjMatrix[i];
            for (int j = 0; j < is.length; j++) {
                int k = is[j];
                System.out.print(k + ", ");
            }
            System.out.println("");
        }
        
        return adjMatrix;
    }

    public static void main(String[] args) {

        try {
            int matrix[][] = readFile();

            DFS.init(matrix);

            System.out.println("\nCourses\t Discovery Time\t Finishing Time");
            System.out.println("---------------------------------------");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
