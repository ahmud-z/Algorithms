package com.ahmudz.dfs_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DFS {

    static char allNodes[] = {'S', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    static int node = allNodes.length;
    static int color[] = new int[node];
    static int discoveryTime[] = new int[node];
    static int finishTime[] = new int[node];
    static int time;

    static void init(int graph[][]) {

        for (int i = 0; i < node; i++) {
            color[i] = 0;
            discoveryTime[i] = Integer.MAX_VALUE;
            finishTime[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < node; i++) {
            if (color[i] == 0) {
                runDFS(graph, i);
            }
        }
    }

    static void runDFS(int graph[][], int u) {

        System.out.print(allNodes[u] + " ");
        color[u] = 1;
        time++;
        discoveryTime[u] = time;

        for (int v = 0; v < node; v++) {

            if (graph[u][v] == 1 && color[v] == 0) {
                runDFS(graph, v);
            }
        }
        color[u] = 2;
        time++;
        finishTime[u] = time;
    }
}

public class DFS_Algorithm {

    static int[][] readFile() throws FileNotFoundException {

        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\Algorithms\\topological_graph.txt");

        Scanner file = new Scanner(filePath);

        int node = file.nextInt();
        int edge = file.nextInt();

        int adjMatrix[][] = new int[node][node];

        while (file.hasNext()) {

            int i = file.nextInt();
            int j = file.nextInt();

            adjMatrix[i][j] = 1;        // Directed Graph
        }

        return adjMatrix;
    }

    public static void main(String[] args) {

        try {

            int matrix[][] = readFile();

            System.out.println("\nTraversed DFS: ");
            DFS.init(matrix);

            System.out.println("");
            System.out.println("\nNode\tdTime\tfTime");
            System.out.println("----------------------");

            for (int i = 0; i < DFS.node; i++) {

                System.out.println(DFS.allNodes[i] + "\t " + DFS.discoveryTime[i] + "\t " + DFS.finishTime[i]);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
