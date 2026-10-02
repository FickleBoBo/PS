package day_13.PGMS_LV3_섬_연결하기;

import java.util.*;

class Solution {

    // 유니온 파인드 부모 배열
    static int[] p;

    // find-set
    static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union-set
    static void union(int x, int y){
        p[y] = x;
    }

    public int solution(int n, int[][] costs) {

        // 간선 배열
        PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int[] cost : costs) edges.offer(cost);

        // make-set
        p = new int[n];
        for(int i=0 ; i<n ; i++) p[i] = i;

        // 크루스칼 알고리즘
        int sum = 0;
        int cnt = 0;
        while(!edges.isEmpty()){
            int[] e = edges.poll();

            int a = find(e[0]);
            int b = find(e[1]);

            if(a == b) continue;    // 같은 집합이면 continue

            union(a, b);
            sum += e[2];
            cnt++;

            if(cnt == n-1) break;
        }

        return sum;
    }
}

// 테스트 1 〉	통과 (0.83ms, 87.2MB)
// 테스트 2 〉	통과 (0.81ms, 78.3MB)
// 테스트 3 〉	통과 (0.92ms, 73.5MB)
// 테스트 4 〉	통과 (0.89ms, 78.3MB)
// 테스트 5 〉	통과 (0.97ms, 81.7MB)
// 테스트 6 〉	통과 (0.74ms, 78.1MB)
// 테스트 7 〉	통과 (1.15ms, 75MB)
// 테스트 8 〉	통과 (0.59ms, 71.6MB)
