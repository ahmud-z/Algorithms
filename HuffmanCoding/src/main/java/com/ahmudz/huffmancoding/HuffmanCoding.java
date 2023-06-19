package com.ahmudz.huffmancoding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class SortByFreq implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode ob1, HuffmanNode ob2) {
        return ob1.item - ob2.item;
    }
}

class HuffmanNode {

    int item;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

public class HuffmanCoding {

    static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "     |   " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        String str;
//
//        System.out.println("Enter your String: ");
//        str = input.next();
//
//        int amount = str.length();
        int amount = 5;
        char[] charArray = {'A', 'B', 'C', 'D', 'R'};
        int[] charFreqArray = {5, 2, 1, 1, 2};

//        for (int i = 0; i < charArray.length; i++) {
//            charArray[i] = str.charAt(i);
//        }
//
//        System.out.println("Enter the frequences: ");
//
//        for (int i = 0; i < charFreqArray.length; i++) {
//            charFreqArray[i] = input.nextInt();
//        }
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(amount, new SortByFreq());

        for (int i = 0; i < amount; i++) {

            HuffmanNode node = new HuffmanNode();
            node.c = charArray[i];
            node.item = charFreqArray[i];
            node.left = null;
            node.right = null;
            q.add(node);
        }
        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode node1 = q.peek();
            q.poll();
            HuffmanNode node2 = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = node1.item + node2.item;
            f.c = '-';
            f.left = node1;
            f.left = node2;
            root = f;
            q.add(f);
        }

        System.out.println("Char | Code");
        System.out.println("---------------");

        System.out.println(root + "");
    }
}
