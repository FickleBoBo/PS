package day_08.Softeer_6248;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adjReverse = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            adjReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adjReverse.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Set<Integer> sTotSet = new HashSet<>();  // S에서 갈 수 있는 모든 점을 담은 Set(T를 만나면 종료)
        Set<Integer> tToAllSet = new HashSet<>();  // T에서 갈 수 있는 모든 점을 담은 Set
        Set<Integer> tTosSet = new HashSet<>();  // T에서 갈 수 있는 모든 점을 담은 Set(S를 만나면 종료)
        Set<Integer> sToAllSet = new HashSet<>();  // S에서 갈 수 있는 모든 점을 담은 Set

        dfs(S, T, adj, sTotSet);
        dfs(T, 0, adjReverse, tToAllSet);
        dfs(T, S, adj, tTosSet);
        dfs(S, 0, adjReverse, sToAllSet);

        sTotSet.retainAll(tToAllSet);  // sTotSet과 tToAllSet의 교집합은 출근길 경로에 포함되는 점
        tTosSet.retainAll(sToAllSet);  // tTosSet과 sToAllSet의 교집합은 퇴근길 경로에 포함되는 점

        sTotSet.retainAll(tTosSet);  // sTotSet과 tTosSet의 교집합은 출퇴근길 경로에 포함되는 점

        System.out.println(sTotSet.size());
    }

    private static void dfs(int node, int target, List<List<Integer>> adj, Set<Integer> visited) {
        if (node == target) return;

        visited.add(node);

        for (int next : adj.get(node)) {
            if (visited.contains(next)) continue;

            dfs(next, target, adj, visited);
        }
    }

}
