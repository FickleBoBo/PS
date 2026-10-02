package day_09.BOJ_G3_11437;

import java.io.*;
import java.util.*;

public class Main2 {

    // 트리의 부모를 저장하는 배열로 트리의 각 노드는 부모가 하나밖에 없음
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parents = new int[1+N];

        // 인접리스트로 연결관계 저장
        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 인접리스트에 연결관계를 저장하는데 입력만으로 부모자식 관계를 알 수가 없음
        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adj[nodeA].add(nodeB);
            adj[nodeB].add(nodeA);
        }

        // BFS에서 트리의 각 노드의 높이(레벨)를 배열로 반환
        int[] height = BFS(N, adj);

        int M = Integer.parseInt(br.readLine());

        // 두 정점의 거리를 find 메서드로 구해서 StringBuilder에 저장했다가 한번에 출력
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            // append 연달아 쓰는게 되는데 더 빠른지는 애매하네(다른 문제들 할 때는 더 빨랐음)
            sb.append(find(nodeA, nodeB, height)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 트리의 루트(=1)부터 쭉 BFS 타면서 최단거리를 저장하면 그게 각 노드의 높이가 됨
    private static int[] BFS(int N, List<Integer>[] adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        boolean[] visited = new boolean[1+N];
        visited[1] = true;

        int[] height = new int[1+N];
        int level = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int node = q.poll();
                for(int next : adj[node]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                        parents[next] = node;
                    }
                }
                height[node] = level;
            }
            level++;
        }

        return height;
    }

    // LCA 알고리즘?
    // 각 노드의 높이를 통일하고 높이를 하나씩 줄이면서 같은 부모가 나올때까지 반복
    //
    // 첨에 A의 조상을 전부 다 구하고 B의 부모를 구하면서 A의 조상에 포함되나 구하는 식으로 했는데 너무 느리지만 통과는 됨(아슬아슬)
    // A와 B를 동시에 부모를 구하며 비교하면 안정적으로 통과됨 -> O(N) 풀이?
    // DP를 활용해서 O(log N)에도 풀이 가능하다는데 이해 잘 안됨
    private static int find(int A, int B, int[] height){
        while(height[A] > height[B]){
            A = parents[A];
        }
        while(height[A] < height[B]){
            B = parents[B];
        }

        while(A != B){
            A = parents[A];
            B = parents[B];
        }

        return A;
    }

}
