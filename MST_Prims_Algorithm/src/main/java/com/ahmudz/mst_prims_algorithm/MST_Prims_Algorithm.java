package com.ahmudz.mst_prims_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MST {

    void printMST(int graph[][], int parent[]) {

        int totalCost = 0;
        System.out.println("Edge\tWeight");
        System.out.println("--------------");

        for (int i = 0; i < graph.length; i++) {

            if (parent[i] != -1) {
                System.out.println(parent[i] + "--" + i + "\t  " + graph[i][parent[i]]);
                totalCost = totalCost + graph[i][parent[i]];
            }
        }

        System.out.println("Total Minimum Cost: " + totalCost);
    }

    int minKey(int key[], boolean mstSet[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < key.length; i++) {
            if (key[i] < min && mstSet[i] == false) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    void primsMST(int graph[][]) {

        int node = graph.length;
        int parent[] = new int[node];
        int key[] = new int[node];
        boolean mstSet[] = new boolean[node];

        for (int i = 0; i < node; i++) {

            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        int sourceNode = 0;
        key[sourceNode] = 0;
        parent[sourceNode] = -1;

        for (int i = 0; i < node - 1; i++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < node; v++) {

                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(graph, parent);
    }
}

public class MST_Prims_Algorithm {

    static int[][] readFile() throws FileNotFoundException {

        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\Algorithms\\weighted_graph_02.txt");
        Scanner file = new Scanner(filePath);

        int node = file.nextInt();
        int edge = file.nextInt();

        int adjMatrix[][] = new int[node][node];

        while (file.hasNext()) {

            int i = file.nextInt();
            int j = file.nextInt();
            int weight = file.nextInt();

            adjMatrix[i][j] = weight;
            adjMatrix[j][i] = weight;
        }
        return adjMatrix;
    }

    public static void main(String[] args) {

        try {

            int matrix[][] = readFile();

            MST ob = new MST();
            ob.primsMST(matrix);

        } catch (FileNotFoundException e) {
        }

    }
}
