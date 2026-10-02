package day_20.PGMS_LV3_등산코스_정하기;

import java.util.*;

class Solution {

    // 노드 클래스
    static class Node implements Comparable<Node> {
        int v;    // 노드의 번호
        int w;    // 노드의 가중치(실제로 다익스트라에서 시작노드에서 해당노드까지 최소 intensity가 저장됨)

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node o){
            // w가 같으면 v에 대해서도 정렬을 해줘야 하는데 다익스트라에서 intensity가 같은 봉우리를 여러 개 발견했을 때, 가장 번호가 작은 봉우리를 리턴해야해서임
            // (다익스트라는 봉우리를 발견하면 바로 리턴하게 짬)
            // 이거 없으면 테케 14, 16, 17 틀림
            if(this.w == o.w){
                return Integer.compare(this.v, o.v);
            }
            return Integer.compare(this.w, o.w);
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        // 인접 리스트 초기화
        adj = new ArrayList[1+n];
        for(int i=1 ; i<=n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0 ; i<paths.length ; i++){
            int st = paths[i][0];
            int ed = paths[i][1];
            int w = paths[i][2];
            adj[st].add(new Node(ed, w));
            adj[ed].add(new Node(st, w));
        }

        // 쉼터는 0, 출입구는 1, 봉우리는 2 를 저장하는 체크용 배열(시간 단축용)
        checkArr = new int[1+n];
        for(int g : gates) { checkArr[g] = 1; }
        for(int s : summits) { checkArr[s] = 2; }

        // 조건1 - intensity가 가장 작아야 함
        // 조건2 - intensity가 같은 코스가 여러 개면 봉우리 번호가 작아야 함
        // answer[0]을 0으로 초기화해도 통과가 되기는 함(조건문 때문에 당연한건가?)
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        // 각 출입구에 대한 Dijkstra
        for(int g : gates) {
            int[] result = Dijkstra(g, n);

            // 더 작은 intensity의 코스를 발견하면 갱신
            if(result[1] < answer[1]){
                answer[0] = result[0];
                answer[1] = result[1];
            }
            // intensity가 answer와 동일한 코스를 또 발견하면 봉우리 번호가 작아지게 갱신
            // 이거 없으면 테케 14, 15, 16, 17, 25 틀림
            else if(result[1] == answer[1] && result[0] < answer[0]){
                answer[0] = result[0];
            }
        }

        return answer;
    }

    // 인접 리스트
    static List<Node>[] adj;

    // 체크용 배열
    static int[] checkArr;

    // 다익스트라에서 거리 배열은 덧셈 때문에 절대 Integer.MAX_VALUE로 초기화 하면 안됨(이 문제는 상관 없음)
    static final int INF = Integer.MAX_VALUE;

    // 각각의 출입구에서 가장 가까운 봉우리를 찾는 다익스트라 알고리즘으로 문제 해결
    // 문제에서 예시 코스만 보면 뭐지 싶은데 노드의 중복 방문이 가능해서 출입구에서 봉우리를 찾으면 왔던 길로 그대로 돌아간다고 생각하면 됨
    // 그래서 특정 출입구에서 가장 가까운 봉우리를 찾기만 하는 코드로 짜도 상관없음(그냥 이게 출제 의도인듯)
    // 출입구(start)에서 봉우리를 찾는 즉시 리턴을 하게 짜야 시간초과 안남(모든 봉우리의 intensity 다 찾고 최소값 반환 X)
    // 기존의 다익스트라는 누적 거리를 계산하며 dist 배열을 갱신하는데 이거는 그동안 찾은 가중치의 최댓값으로 갱신하는게 다름
    static int[] Dijkstra(int start, int n){

        // 다익스트라는 무조건 우선순위 큐로 해야됨
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[1+n];

        int[] dist = new int[1+n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            // 봉우리를 찾았을 때, 해당 봉우리가 start에서 가장 intensity가 낮은 봉우리이므로 다른 봉우리를 더 찾을 필요가 없음
            if(checkArr[node.v]==2){
                return new int[]{node.v, dist[node.v]};
            }

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(checkArr[next.v]==1) continue;    // 다른 출입구를 거쳐가는 코스는 문제 조건에서 안됨

                if(!visited[next.v] && (Math.max(dist[node.v], next.w) < dist[next.v])){
                    dist[next.v] = Math.max(dist[node.v], next.w);
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        // 다익스트라 다 돌고 봉우리를 못 찾으면(이럴 일은 아예 없는줄 알았음) return new int[]{-1, -1}로 하니까 테케 7, 8, 11, 12, 22, 23, 24 틀림
        // 출입구 위치가 억까로 배치돼서 봉우리를 못 찾는 출입구가 있는 것으로 보임(연결 그래프이고, 봉우리는 하나 이상은 반드시 존재하긴 함)
        // return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}; 로 하면 answer가 갱신될 일이 없어서 이렇게 리턴함
        return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    }

}

/*
테스트 1 〉	통과 (0.76ms, 91.1MB)
테스트 2 〉	통과 (1.06ms, 75.6MB)
테스트 3 〉	통과 (0.77ms, 91.9MB)
테스트 4 〉	통과 (0.85ms, 78.9MB)
테스트 5 〉	통과 (0.65ms, 78.2MB)
테스트 6 〉	통과 (0.84ms, 85.6MB)
테스트 7 〉	통과 (1.02ms, 77.7MB)
테스트 8 〉	통과 (0.73ms, 73.1MB)
테스트 9 〉	통과 (1.58ms, 78.3MB)
테스트 10 〉	통과 (1.97ms, 72.2MB)
테스트 11 〉	통과 (1.63ms, 73.4MB)
테스트 12 〉	통과 (1.71ms, 71.4MB)
테스트 13 〉	통과 (5.28ms, 80.7MB)
테스트 14 〉	통과 (30.04ms, 106MB)
테스트 15 〉	통과 (104.50ms, 161MB)
테스트 16 〉	통과 (98.21ms, 146MB)
테스트 17 〉	통과 (108.51ms, 158MB)
테스트 18 〉	통과 (13.68ms, 95.3MB)
테스트 19 〉	통과 (18.90ms, 116MB)
테스트 20 〉	통과 (89.09ms, 149MB)
테스트 21 〉	통과 (124.00ms, 128MB)
테스트 22 〉	통과 (56.87ms, 148MB)
테스트 23 〉	통과 (321.96ms, 382MB)
테스트 24 〉	통과 (391.73ms, 400MB)
테스트 25 〉	통과 (837.31ms, 556MB)
*/
