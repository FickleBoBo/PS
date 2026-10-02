package day_02.BOJ_21276;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 자식들을 저장하는 트리맵
        Map<String, TreeSet<String>> childrenMap = new TreeMap<>();

        // 자식 + 자손들을 저장하는 해시맵
        Map<String, List<String>> descendantMap = new HashMap<>();

        // 진입차수를 저장하는 해시맵
        Map<String, Integer> indegree = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();

            childrenMap.put(name, new TreeSet<>());
            descendantMap.put(name, new ArrayList<>());
            indegree.put(name, 0);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String descendant = st.nextToken();
            String ancestor = st.nextToken();

            descendantMap.get(ancestor).add(descendant);
            indegree.put(descendant, indegree.get(descendant) + 1);
        }

        // 가문의 시조들을 저장하는 트리셋
        Set<String> root = new TreeSet<>();

        topologicalSort(root, childrenMap, descendantMap, indegree);

        String ans = print(root, childrenMap);

        bw.write(ans);
        bw.flush();
    }

    // 가문의 시조부터 수행하는 위상정렬
    private static void topologicalSort(Set<String> root, Map<String, TreeSet<String>> childrenMap, Map<String, List<String>> descendantMap, Map<String, Integer> indegree) {
        Queue<String> q = new ArrayDeque<>();

        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
                root.add(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            String name = q.remove();

            for (String descendant : descendantMap.get(name)) {
                indegree.put(descendant, indegree.getOrDefault(descendant, 0) - 1);
                if (indegree.get(descendant) == 0) {
                    q.add(descendant);
                    childrenMap.get(name).add(descendant);
                }
            }
        }
    }

    // 출력용 메서드
    private static String print(Set<String> root, Map<String, TreeSet<String>> childrenMap) {
        StringBuilder sb = new StringBuilder();

        sb.append(root.size()).append("\n");

        for (String name : root) {
            sb.append(name).append(" ");
        }
        sb.append("\n");

        for (Map.Entry<String, TreeSet<String>> entry : childrenMap.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue().size()).append(" ");

            for (String child : entry.getValue()) {
                sb.append(child).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
