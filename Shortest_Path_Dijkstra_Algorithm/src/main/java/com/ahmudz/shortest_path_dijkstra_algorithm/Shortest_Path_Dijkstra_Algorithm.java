package com.ahmudz.shortest_path_dijkstra_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shortest_Path_Dijkstra_Algorithm {

    int FindMinKey(int distance[], boolean sptSet[]) {

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] <= minValue && sptSet[i] == false) {
                minValue = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    void printResult(int distance[]) {

        System.out.println("\nSingle Source Shortest Path Distances");
        System.out.println("\nNode\t\tDistance");
        System.out.println("------------------------");

        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t   " + distance[i]);
        }
    }

    void dijkstraTraverse(int graph[][], int sourceNode) {

        int node = graph.length;
        int distance[] = new int[node];
        boolean sptSet[] = new boolean[node];

        for (int i = 0; i < node; i++) {

            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        distance[sourceNode] = 0;

        for (int i = 0; i < node - 1; i++) {

            int u = FindMinKey(distance, sptSet);
            sptSet[u] = true;

            for (int j = 0; j < node; j++) {

                if (sptSet[j] == false && graph[u][j] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][j] < distance[j]) {

                    distance[j] = distance[u] + graph[u][j];
                }
            }

        }

        printResult(distance);
    }

    static int[][] readFile() throws FileNotFoundException {

        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\dijkstra_graph_edges.txt");
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
            int graph[][] = readFile();

            Shortest_Path_Dijkstra_Algorithm ob = new Shortest_Path_Dijkstra_Algorithm();

            ob.dijkstraTraverse(graph, 0);

        } catch (Exception e) {
        }

    }
}
