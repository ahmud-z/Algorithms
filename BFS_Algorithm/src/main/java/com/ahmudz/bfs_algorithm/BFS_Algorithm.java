package com.ahmudz.bfs_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFS {

    public BFS(int matrix[][]) {
        runBFS(matrix);
    }
    
    void runBFS(int graph[][]) {

        int node = graph.length;      //graph length
        int visited[] = new int[node];
        int parent[] = new int[node];
        int level[] = new int[node];

        for (int i = 0; i < node; i++) {
            visited[i] = 0;          // mark as white
            parent[i] = -1;         // mark as no parent 
            level[i] = 999999;     // infinty level
        }

        int sourceNode = 0;
        visited[sourceNode] = 1;    //mark as gray
        level[sourceNode] = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(sourceNode);

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int i = 0; i < node; i++) {

                if (graph[u][i] == 1 && visited[i] == 0) {

                    visited[i] = 1;
                    level[i] = level[u] + 1;
                    parent[i] = u;
                    q.add(i);       // added child into the queue
                }
            }
            visited[u] = 2; //mark as black
        }

        System.out.println("\nNode\tLevel\tParent");
        for (int i = 0; i < node; i++) {
            System.out.println(i + "\t " + level[i] + "\t " + parent[i]);
        }
    }

}

public class BFS_Algorithm {

    static int[][] readFile() throws FileNotFoundException {

        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\Algorithms\\graph_edges.txt");

        Scanner file = new Scanner(filePath);

        int node = file.nextInt();
        int edge = file.nextInt();

        int adjMatrix[][] = new int[node][node];

        while (file.hasNext()) {

            int i = file.nextInt();
            int j = file.nextInt();

            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1;
        }

        return adjMatrix;
    }

    public static void main(String[] args) {

        try {
            int matrix[][] = readFile();

            BFS ob = new BFS(matrix);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
