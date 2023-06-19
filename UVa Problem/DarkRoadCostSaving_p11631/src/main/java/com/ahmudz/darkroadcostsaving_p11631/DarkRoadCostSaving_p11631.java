package com.ahmudz.darkroadcostsaving_p11631;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SortByWeight implements Comparator<Edge> {

    @Override
    public int compare(Edge ob1, Edge ob2) {
        return ob1.weight - ob2.weight;
    }
}

class Edge {

    int source;
    int destination;
    int weight;

    public Edge() {
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

}

public class DarkRoadCostSaving_p11631 {

    static int calculateMSTCost(Edge arr[]) {

        int cost = 0;
        int leaderArray[] = new int[arr.length];

        for (int i = 0; i < leaderArray.length; i++) {
            leaderArray[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {

            Edge currentNode = arr[i];

            int x = leaderArray[currentNode.source];
            int y = leaderArray[currentNode.destination];

            if (x != y) {
                cost += currentNode.weight;

                if (x < y) {
                    for (int j = 0; j < leaderArray.length; j++) {
                        if (leaderArray[j] == y) {
                            leaderArray[j] = x;
                        }
                    }
                } else {
                    for (int j = 0; j < leaderArray.length; j++) {
                        if (leaderArray[j] == x) {
                            leaderArray[j] = y;
                        }
                    }
                }
            }

        }
        return cost;
    }

    static void readGraph() throws FileNotFoundException {

        File filePath = new File("C:\\Users\\Mahmud\\Desktop\\Algorithms\\UVa Problem\\ByteLandData.txt");
        Scanner file = new Scanner(filePath);

        while (true) {
            int m = file.nextInt();
            int n = file.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            Edge edges[] = new Edge[n];
            int initialCost = 0;

            for (int i = 0; i < n; i++) {
                int source = file.nextInt();
                int destination = file.nextInt();
                int weight = file.nextInt();

                initialCost += weight;
                edges[i] = new Edge(source, destination, weight);
            }

            Arrays.sort(edges, new SortByWeight());

            int canSave = initialCost - calculateMSTCost(edges);

            System.out.println(canSave);

        }
    }

    public static void main(String[] args) {

        try {
            readGraph();
        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        }
    }
}

/*
    filePath = create File object with path 

file = create Scanner object for filePath
    
    while true:
        nodeAmount = read the next integer from file
        edgeAmount = read the next integer from file
        
        if nodeAmount is equal to 0 and edgeAmount is equal to 0:
            exit the loop
        
        edges = create an empty array of size edgeAmount
        
        initialCost = 0
        
        for i = 0 to n - 1:
            source = read the next integer from file
            destination = read the next integer from file
            weight = read the next integer from file
            
            initialCost = initialCost + weight
            
            edges[i] = create Edge object with source, destination, and weight
        
        sort edges using SortByWeight
        
        canSave = initialCost - calculateMSTCost(edges)
        
        print canSave
*/