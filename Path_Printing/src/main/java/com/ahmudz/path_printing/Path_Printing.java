package com.ahmudz.path_printing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class DFS {

    static char allNodes[] = {0, 1, 2, 3, 4, 5, 6, 7};
    static int node = allNodes.length;
    static int color[] = new int[node];
    static int discoveryTime[] = new int[node];
    static int finishTime[] = new int[node];
    static int parent[] = new int[node];

    static int time;
    static int sourceNode;
    static int destinationNode;
    static Queue<Integer> path = new LinkedList<>();

    static void init(int graph[][]) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < node; i++) {
            color[i] = 0;
            discoveryTime[i] = Integer.MAX_VALUE;
            finishTime[i] = Integer.MAX_VALUE;
        }

        System.out.print("Enter source node: ");
        sourceNode = input.nextInt();

        System.out.print("Enter destination source node: ");
        destinationNode = input.nextInt();

        runDFS(graph, sourceNode);

    }

    static void runDFS(int graph[][], int u) {

//        System.out.print(allNodes[u] + " ");
        color[u] = 1;
        time++;
        discoveryTime[u] = time;

        while (color[destinationNode] != 2) {
            for (int v = 0; v < destinationNode; v++) {

                if (graph[u][v] == 1 && color[v] == 0) {
                    runDFS(graph, v);
                    parent[v] = allNodes[u];
                    path.add(parent[v]);
                }
            }

            color[u] = 2;
            time++;
            finishTime[u] = time;

        }

        while (!path.isEmpty()) {
            int k = path.poll();
            System.out.print(+k + " ");
        }
    }
}

public class Path_Printing {

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

            for (int i = 0; i < matrix.length; i++) {
            }

        } catch (Exception e) {

        }

    }
}

//
//            System.out.println("\nTraversed DFS: ");
//            DFS.init(matrix);
//
//            System.out.println("");
//            System.out.println("\nNode\tdTime\tfTime");
//            System.out.println("----------------------");
//
//            for (int i = 0; i < DFS.node; i++) {
//
//                System.out.println(DFS.allNodes[i] + "\t " + DFS.discoveryTime[i] + "\t " + DFS.finishTime[i]);
//            }
