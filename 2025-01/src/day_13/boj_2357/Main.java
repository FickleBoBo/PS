package day_13.BOJ_2357;

import java.io.*;
import java.util.*;

public class Main {

    private static class SegmentTree {
        private final int N;
        private final int[] minTree;
        private final int[] maxTree;

        public SegmentTree(int[] arr) {
            this.N = arr.length;
            this.minTree = new int[4 * N];
            this.maxTree = new int[4 * N];
            init(arr, 1, 0, N - 1);
        }

        private void init(int[] arr, int node, int start, int end) {
            initMinTree(arr, node, start, end);
            initMaxTree(arr, node, start, end);
        }

        private int initMinTree(int[] arr, int node, int start, int end) {
            if (start == end) return minTree[node] = arr[start];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return minTree[node] = Math.min(initMinTree(arr, leftChild, start, mid), initMinTree(arr, rightChild, mid + 1, end));
        }

        private int initMaxTree(int[] arr, int node, int start, int end) {
            if (start == end) return maxTree[node] = arr[start];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return maxTree[node] = Math.max(initMaxTree(arr, leftChild, start, mid), initMaxTree(arr, rightChild, mid + 1, end));
        }

        private String query(int left, int right) {
            return new StringBuilder()
                    .append(min(1, 0, N - 1, left, right))
                    .append(" ")
                    .append(max(1, 0, N - 1, left, right))
                    .toString();
        }

        private int min(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return Integer.MAX_VALUE;

            if (left <= start && end <= right) return minTree[node];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return Math.min(min(leftChild, start, mid, left, right), min(rightChild, mid + 1, end, left, right));
        }

        private int max(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return Integer.MIN_VALUE;

            if (left <= start && end <= right) return maxTree[node];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return Math.max(max(leftChild, start, mid, left, right), max(rightChild, mid + 1, end, left, right));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(tree.query(a - 1, b - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
