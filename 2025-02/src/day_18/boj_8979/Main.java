package day_18.BOJ_8979;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int num;
        int order;
        int gold;
        int silver;
        int bronze;

        public Node(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze));
        }
        list.sort(((o1, o2) -> {
            if (o1.gold != o2.gold) return Integer.compare(o2.gold, o1.gold);
            if (o1.silver != o2.silver) return Integer.compare(o2.silver, o1.silver);
            return Integer.compare(o2.bronze, o1.bronze);
        }));

        list.get(0).order = 1;
        for (int i = 1; i < N; i++) {
            Node before = list.get(i - 1);
            Node curr = list.get(i);

            if (curr.gold == before.gold && curr.silver == before.silver && curr.bronze == before.bronze) {
                curr.order = before.order;
            } else {
                curr.order = i + 1;
            }
        }
        list.sort(((o1, o2) -> Integer.compare(o1.num, o2.num)));

        System.out.println(list.get(K - 1).order);
    }
}
