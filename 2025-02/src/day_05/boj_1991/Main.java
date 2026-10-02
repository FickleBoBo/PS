package day_05.BOJ_1991;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        char leftChild;
        char rightChild;

        public Node(char leftChild, char rightChild) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private static final StringBuilder sb = new StringBuilder();
    private static final Map<Character, Node> adj = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            adj.put(node, new Node(leftChild, rightChild));
        }

        preorder('A');
        sb.append("\n");

        inorder('A');
        sb.append("\n");

        postorder('A');

        bw.write(sb.toString());
        bw.flush();
    }

    // 전위 순회
    private static void preorder(char node) {
        if (node == '.') return;

        sb.append(node);
        preorder(adj.get(node).leftChild);
        preorder(adj.get(node).rightChild);
    }

    // 중위 순회
    private static void inorder(char node) {
        if (node == '.') return;

        inorder(adj.get(node).leftChild);
        sb.append(node);
        inorder(adj.get(node).rightChild);
    }

    // 후위 순회
    private static void postorder(char node) {
        if (node == '.') return;

        postorder(adj.get(node).leftChild);
        postorder(adj.get(node).rightChild);
        sb.append(node);
    }

}
