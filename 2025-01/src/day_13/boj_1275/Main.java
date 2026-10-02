package day_13.BOJ_1275;

import java.io.*;
import java.util.*;

public class Main {

    private static class SegmentTree {
        private final int N;
        private final long[] tree;

        public SegmentTree(int[] arr) {
            this.N = arr.length;
            this.tree = new long[4 * N];
            init(arr, 1, 0, N - 1);
        }

        private long init(int[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return tree[node] = init(arr, leftChild, start, mid) + init(arr, rightChild, mid + 1, end);
        }

        private long query(int left, int right) {
            return query(1, 0, N - 1, left, right);
        }

        private long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0;

            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return query(leftChild, start, mid, left, right) + query(rightChild, mid + 1, end, left, right);
        }

        private void update(int idx, int value) {
            update(1, 0, N - 1, idx, value);
        }

        private void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            if (idx <= mid) {
                update(leftChild, start, mid, idx, value);
            } else {
                update(rightChild, mid + 1, end, idx, value);
            }

            tree[node] = tree[leftChild] + tree[rightChild];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(tree.query(Math.min(x, y) - 1, Math.max(x, y) - 1)).append("\n");
            tree.update(a - 1, b);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
