package day_13.BOJ_11505;

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

            return tree[node] = init(arr, leftChild, start, mid) * init(arr, rightChild, mid + 1, end) % MOD;
        }

        private long query(int left, int right) {
            return query(1, 0, N - 1, left, right);
        }

        private long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1;

            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return query(leftChild, start, mid, left, right) * query(rightChild, mid + 1, end, left, right) % MOD;
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

            tree[node] = tree[leftChild] * tree[rightChild] % MOD;
        }

    }

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(arr);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) tree.update(b - 1, c);
            else sb.append(tree.query(b - 1, c - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
