package com.ahmudz.kruskal_second_best_mst;

import java.util.*;

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

public class Kruskal_Second_Best_MST {

    int nodeAmount;
    int leaderArray[];

    public Kruskal_Second_Best_MST(int nodeAmount, int edgeAmount) {
        this.nodeAmount = nodeAmount;
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

    Edge[] findMst(Edge arr[], int skipEdgeIndex) {

        Edge resultArray[] = new Edge[nodeAmount - 1];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Edge();
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

            Edge nextEdge = arr[v];

            int x = findLeader(nextEdge.source);
            int y = findLeader(nextEdge.destination);

            if (x != y) {
                resultArray[resultIndex++] = nextEdge;
                union(x, y);
            }
        }

        return resultArray;
    }

    int calculateCost(Edge[] resultArray) {

        int cost = 0;

        for (int i = 0; i < resultArray.length; i++) {
            cost += resultArray[i].weight;
        }

        return cost;
    }

    void printResultTree(Edge[] resultArray) {
        for (int i = 0; i < resultArray.length; i++) {
            Edge edge = resultArray[i];

            System.out.println("  " + edge.source + "\t   " + edge.destination + "\t     " + edge.weight);
        }
    }

    public static void main(String[] args) {

        Edge arr[] = {
            new Edge(0, 1, 4),
            new Edge(0, 2, 4),
            new Edge(1, 2, 2),
            new Edge(2, 3, 3),
            new Edge(2, 4, 2),
            new Edge(2, 5, 4),
            new Edge(3, 5, 3),
            new Edge(4, 5, 3)
        };

        Kruskal_Second_Best_MST ob = new Kruskal_Second_Best_MST(6, 8);

        Edge[] bestMstTree = ob.findMst(arr, 9999);
        int bestMstCost = ob.calculateCost(bestMstTree);

        System.out.println("Minimunm Spanning cost: " + bestMstCost);
        System.out.println("Source Destination Weight");
        ob.printResultTree(bestMstTree);

        List<Integer> scores = new ArrayList<>();
        Map<Integer, Edge[]> trees = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            Edge[] tree = ob.findMst(arr, i);
            int cost = ob.calculateCost(tree);

            trees.put(cost, tree);

            if (scores.contains(cost) == false) {
                scores.add(cost);
            }
        }

        Collections.sort(scores);
        int secondBestScore = scores.get(1);

        System.out.println("Second best MST cost: " + secondBestScore);

        Edge[] secondTree = trees.get(secondBestScore);

        ob.printResultTree(secondTree);
    }

}
