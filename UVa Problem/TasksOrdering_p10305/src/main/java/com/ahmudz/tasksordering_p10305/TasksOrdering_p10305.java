package com.ahmudz.tasksordering_p10305;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class DFS {

    static void init(int graph[][]) {

        for (int i = 0; i < graph.length; i++) {

        }
    }

    static void runDFS(int arr[][]) {

    }
}

public class TasksOrdering_p10305 {

    static void readGraph() throws FileNotFoundException {
        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\F.txt");
        Scanner file = new Scanner(filePath);

        while (true) {
            int m = file.nextInt();
            int n = file.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            int adjMatrix[][] = new int[m][m];

            for (int l = 0; l < n; l++) {
                int i = file.nextInt();
                int j = file.nextInt();

                adjMatrix[m - 1][n - 1] = 1;
            }

        }
    }

    public static void main(String[] args) {

        try {
            readGraph();

        } catch (FileNotFoundException e) {
        }
    }
}
