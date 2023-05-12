package com.ahmudz.topological_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class DFS {

    static String allNodes[] = {"shorts", "socks", "pants", "shoes", "blet", "shirt", "tie", "jacket", "watch"};
    static int node = allNodes.length;
    static int color[] = new int[node];
    static int discoveryTime[] = new int[node];
    static int finishTime[] = new int[node];
    static int time;

    static Stack<String> stk = new Stack<>();

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
        stk.push(allNodes[u]);
    }

    static void topoSort() {

        System.out.println("\nTopologicallay sorted list: ");
        while (!stk.empty()) {
            System.out.print(stk.pop() + " -- ");
        }
    }

}

public class Topological_Sort {

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
            DFS.init(matrix);

            System.out.println("\nNode\tdTime\tfTime");

            for (int i = 0; i < DFS.node; i++) {
                System.out.println(DFS.allNodes[i] + "\t" + DFS.discoveryTime[i] + "\t" + DFS.finishTime[i]);
            }

            DFS.topoSort();

        } catch (Exception e) {
        }

    }
}
