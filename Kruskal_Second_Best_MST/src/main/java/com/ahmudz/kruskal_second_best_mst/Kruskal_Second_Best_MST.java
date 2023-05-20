package com.ahmudz.kruskal_second_best_mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByWeight implements Comparator<Edges> {

    @Override
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

public class Kruskal_Second_Best_MST {

    int nodeAmount;
    int edgeAmount;
    int leaderArray[];

    public Kruskal_Second_Best_MST(int nodeAmount, int edgeAmount) {
        this.nodeAmount = nodeAmount;
        this.edgeAmount = edgeAmount;
        leaderArray = new int[nodeAmount];
    }

    int findLeader(int u) {
        return leaderArray[u];
    }

    void union(int rootU, int rootV) {
        if (rootU < rootV) {
            for (int i = 0; i < leaderArray.length; i++) {
                if (leaderArray[i] == rootV) {
                    leaderArray[i] = rootU;
                }
            }
        } else {

            for (int i = 0; i < leaderArray.length; i++) {
                if (leaderArray[i] == rootU) {
                    leaderArray[i] = rootV;
                }
            }
        }
    }

    int findSecondBestMST(Edges arr[], int skipEdgeIndex) {

        Edges resultArray[] = new Edges[nodeAmount - 1];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Edges();
        }

        Arrays.sort(arr, new SortByWeight());

        for (int i = 0; i < leaderArray.length; i++) {
            leaderArray[i] = i;
        }

        int resultIndex = 0;

        for (int v = 0; v < arr.length; v++) {

            if (skipEdgeIndex != 9999 && skipEdgeIndex == v) {
                continue;
            }

            Edges nextEdge = arr[v];

            int x = findLeader(nextEdge.source);
            int y = findLeader(nextEdge.destination);

            if (x != y) {
                resultArray[resultIndex++] = nextEdge;
                union(x, y);
            }
        }

        int cost = 0;
        for (int i = 0; i < resultArray.length; i++) {
            cost += resultArray[i].weight;
        }
        return cost;
    }

    public static void main(String[] args) {

        Edges arr[] = {
            new Edges(0, 1, 10),
            new Edges(0, 2, 6),
            new Edges(0, 3, 5),
            new Edges(1, 3, 15),
            new Edges(2, 3, 4)
        };

        Kruskal_Second_Best_MST ob = new Kruskal_Second_Best_MST(4, 5);

        System.out.println("Minimunm Spanning cost: " + ob.findSecondBestMST(arr, 9999));

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int s = ob.findSecondBestMST(arr, i);
            if (scores.contains(s) == false) {
                scores.add(s);
            }
        }

        Collections.sort(scores);

        System.out.println("Second best MST: " + scores.get(1));
    }

}
