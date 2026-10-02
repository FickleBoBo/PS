package day_13.BOJ_10868;

import java.io.*;
import java.util.*;

public class Main {

    private static class SegmentTree {
        private final int N;
        private final int[] tree;

        public SegmentTree(int[] arr) {
            this.N = arr.length;
            this.tree = new int[4 * N];
            init(arr, 1, 0, N - 1);
        }

        private int init(int[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return tree[node] = Math.min(init(arr, leftChild, start, mid), init(arr, rightChild, mid + 1, end));
        }

        private int query(int left, int right) {
            return query(1, 0, N - 1, left, right);
        }

        private int query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return Integer.MAX_VALUE;

            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return Math.min(query(leftChild, start, mid, left, right), query(rightChild, mid + 1, end, left, right));
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
