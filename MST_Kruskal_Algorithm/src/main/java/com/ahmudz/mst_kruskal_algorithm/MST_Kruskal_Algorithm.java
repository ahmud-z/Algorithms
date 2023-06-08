package com.ahmudz.mst_kruskal_algorithm;

import java.util.Arrays;
import java.util.Comparator;

class SortByWeight implements Comparator<Edges> {

    public int compare(Edges ob1, Edges ob2) {

        return ob1.weight - ob2.weight;
    }
}

class Edges {

    int source;
    int destination;
    int weight;

    public Edges() {
    }

    public Edges(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class MST_Kruskal_Algorithm {

    int nodeAmount;
    int edgeAmount;
    int leader[];

    public MST_Kruskal_Algorithm(int nodeAmount, int edgeAmount) {
        this.nodeAmount = nodeAmount;
        this.edgeAmount = edgeAmount;
        leader = new int[nodeAmount];
    }

    int Find(int u) {
        return leader[u];
    }

    void Union(int rootU, int rootV) {
        if (rootU < rootV) {
            for (int i = 0; i < nodeAmount; i++) {
                if (leader[i] == rootV) {
                    leader[i] = rootU;
                }
            }
        } else {
            for (int i = 0; i < nodeAmount; i++) {
                if (leader[i] == rootU) {
                    leader[i] = rootV;
                }
            }
        }
    }

    int kruskalMST(Edges arr[]) {

        Edges resultArray[] = new Edges[nodeAmount - 1];
        int minCost = 0;

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Edges();
        }

        Arrays.sort(arr, new SortByWeight());

        for (int i = 0; i < leader.length; i++) {
            leader[i] = i;
        }

        int resultIndex = 0;

        for (int j = 0; j < arr.length; j++) {

            Edges nextEdge = arr[j];

            int x = Find(nextEdge.source);
            int y = Find(nextEdge.destination);

            if (x != y) {
                resultArray[resultIndex++] = nextEdge;
                Union(x, y);
            }
        }

        System.out.println("\nSource\tDestination\tWeight");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i].source + "\t  " + resultArray[i].destination + "\t\t  " + resultArray[i].weight);
            minCost += resultArray[i].weight;
        }

        return minCost;
    }

    public static void main(String[] args) {

        Edges arr[] = {
            new Edges(0, 1, 7),
            new Edges(0, 3, 5),
            new Edges(1, 2, 8),
            new Edges(1, 3, 9),
            new Edges(1, 4, 7),
            new Edges(2, 4, 5),
            new Edges(3, 4, 15),
            new Edges(3, 5, 6),
            new Edges(4, 5, 8),
            new Edges(4, 6, 9),
            new Edges(5, 6, 11)};

        MST_Kruskal_Algorithm ob = new MST_Kruskal_Algorithm(7, 11);

        System.out.println("\nMinimum Spanning Tree Cost: " + ob.kruskalMST(arr));
    }
}
