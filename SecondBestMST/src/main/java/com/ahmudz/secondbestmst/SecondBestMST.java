package com.ahmudz.secondbestmst;

import java.io.File;
import java.io.FileNotFoundException;
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

    public Edge(int source, int destinaton, int weight) {
        this.source = source;
        this.destination = destinaton;
        this.weight = weight;
    }
}

public class SecondBestMST {

    int nodeAmount;
    int edgeAmount;
    int leader[];
    static Map<Integer, Edge[]> trees = new HashMap<>();

    public SecondBestMST() {
    }

    public SecondBestMST(int nodeAmount, int edgeAmount) {
        this.nodeAmount = nodeAmount;
        this.edgeAmount = edgeAmount;
        leader = new int[nodeAmount];
    }

    int findLeader(int u) {
        return leader[u];
    }

    void union(int rootU, int rootV) {
        if (rootU < rootV) {
            for (int i = 0; i < leader.length; i++) {
                if (leader[i] == rootV) {
                    leader[i] = rootU;
                }
            }
        } else {
            for (int i = 0; i < leader.length; i++) {
                if (leader[i] == rootU) {
                    leader[i] = rootV;
                }
            }
        }
    }

    static void printTree(Edge[] tree) {
        System.out.println("src   dest  weight");

        for (Edge x : tree) {
            System.out.println(x.source + " -->  " + x.destination + " -->   " + x.weight);
        }
    }

    int findKruskalMST(Edge arr[], int skipEdgeIndex) {

        Edge resultArray[] = new Edge[nodeAmount - 1];
        int cost = 0;

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Edge();
        }

        Arrays.sort(arr, new SortByWeight());

        for (int i = 0; i < leader.length; i++) {
            leader[i] = i;
        }

        int resultIndex = 0;

        for (int j = 0; j < arr.length; j++) {

            if (skipEdgeIndex != 9999 && skipEdgeIndex == j) {
                continue;
            }

            Edge nextEdge = arr[j];

            int x = findLeader(nextEdge.source);
            int y = findLeader(nextEdge.destination);

            if (x != y) {
                resultArray[resultIndex++] = nextEdge;
                union(x, y);
            }
        }

        for (Edge i : resultArray) {
            cost += i.weight;
        }

        trees.put(cost, resultArray);

        return cost;
    }

    static Map<Integer, Object> getGraphFromFile() throws FileNotFoundException {

        Map<Integer, Object> graphData = new HashMap<>();

        File filePath = new File("C:/Users/Mahmud/Desktop/graph_edges.txt");
        Scanner file = new Scanner(filePath);

        int nodeAmount = file.nextInt();
        int edgeAmount = file.nextInt();

        Edge edges[] = new Edge[edgeAmount];

        int x = 0;

        while (file.hasNext()) {

            int src = file.nextInt();
            int dest = file.nextInt();
            int weight = file.nextInt();

            edges[x] = new Edge(src, dest, weight);
            x++;
        }

        graphData.put(0, nodeAmount);
        graphData.put(1, edgeAmount);
        graphData.put(2, edges);

        return graphData;
    }

    public static void main(String[] args) {
        try {

            Map<Integer, Object> graphData = getGraphFromFile();

            int nodeAmount = (int) graphData.get(0);
            int edgeAmount = (int) graphData.get(1);
            Edge arr[] = (Edge[]) graphData.get(2);

            SecondBestMST ob = new SecondBestMST(nodeAmount, edgeAmount);

            int bestCost = ob.findKruskalMST(arr, 9999);
            System.out.println("Best MST Cost: " + bestCost);

            Edge[] tree1 = trees.get(bestCost);
            printTree(tree1);

            List<Integer> scores = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                int s = ob.findKruskalMST(arr, i);
                if (scores.contains(s) == false) {
                    scores.add(s);                  //collection of all individual mst cost
                }
            }

            Collections.sort(scores);           // sorting collection of MST cost

            int secondBestCost = scores.get(1);

            System.out.println("\nSecond Best MST Cost: " + secondBestCost);

            Edge[] tree2 = trees.get(secondBestCost);

            printTree(tree2);

        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
