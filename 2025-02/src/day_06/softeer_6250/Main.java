package day_06.Softeer_6250;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        // 참가자 번호
        int person;
        // 참가자 점수
        int num;
        // 참가자 등수
        int order;

        public Node(int person, int num) {
            this.person = person;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[3][N];
        int[] total = new int[N];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                total[j] += num;
            }
        }

        for (int i = 0; i < 3; i++) {
            Node[] arr = init(N, map[i]);

            for (Node node : arr) {
                sb.append(node.order).append(" ");
            }
            sb.append("\n");
        }

        Node[] arr = init(N, total);
        for (Node node : arr) {
            sb.append(node.order).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static Node[] init(int N, int[] arr) {
        Node[] nodeArr = new Node[N];

        for (int i = 0; i < N; i++) {
            nodeArr[i] = new Node(i, arr[i]);
        }

        Arrays.sort(nodeArr, (o1, o2) -> Integer.compare(o2.num, o1.num));

        int before = nodeArr[0].num;
        nodeArr[0].order = 1;
        for (int i = 1; i < N; i++) {
            if (nodeArr[i].num == before) nodeArr[i].order = nodeArr[i - 1].order;
            else nodeArr[i].order = i + 1;

            before = nodeArr[i].num;
        }

        Arrays.sort(nodeArr, (o1, o2) -> Integer.compare(o1.person, o2.person));

        return nodeArr;
    }

}
