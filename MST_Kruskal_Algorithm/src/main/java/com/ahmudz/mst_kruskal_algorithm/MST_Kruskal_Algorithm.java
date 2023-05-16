package com.ahmudz.mst_kruskal_algorithm;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MST_Kruskal_Algorithm {

    class Edge implements Comparable<Edge> {

        int src, dest, weight;

        public int comareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    int V, E;

    Edge edge[];
    int leader[];

    void Kruskal(int v, int e) {
        V = v;
        E = e;
        leader = new int[V];
        edge = new Edge[E];

        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    int Find(int n) {
        return leader[n];
    }

    void Union(int rootU, int rootV) {

        int newLeader;
        if (rootU < rootV) {
            newLeader = rootU;
            for (int i = 0; i < V; i++) {
                if (leader[i] == rootV) {
                    leader[i] = newLeader;
                }
            }
        } else {

            newLeader = rootV;
            for (int i = 0; i < V; i++) {
                if (leader[i] == leader[u]) {
                    leader[i] = newLeader;
                }
            }
        }
    }

    void kruskalMST() {

        Edge result = new Edge(V - 1);

        for (int i = 0; i < result.length; i++) {

            result[i] = new Edge();
        }

        Arrays.sort(edge);

        for (int i = 0; i < V; ++i) {
            leader[i] = i;
        }

        int i = 0;

        for (int e = 0; e < edge.length; e++) {

            Edge next_edge = edge[e];

            int x = Find(next_edge.src);
            int y = Find(next_edge.dest);

            if (x != y) {
                result[i++] = next_edge;
                Union(x, y);
            }
        }

        System.out.println("Folloing are the edges in" + "the constucted MST");

        int minimumCost = 0;

        for (int p = 0; p < result.length; p++) {

            System.out.println(result[p].src + " --- " + result[p].dest + " == " + result[p].weight);
            minimumCost += result[p].weight;
        }

        System.out.println("Minimum Cost of Spanning Tree: " + minimumCost);
    }

    public static void main(String[] args) {

        int V = 4;
        int E = 5;

        MST_Kruskal_Algorithm graph = new MST_Kruskal_Algorithm(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].dest = 1;
        graph.edge[3].src = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();

    }
}
