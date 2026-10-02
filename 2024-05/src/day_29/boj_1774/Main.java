package day_29.BOJ_G3_1774;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 간선 클래스
    static class Edge implements Comparable<Edge> {
        int x;    // 좌표 x
        int y;    // 좌표 y
        double v;    // x와 y 사이의 거리

        public Edge(int x, int y, double v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        // 간선 배열 정렬을 위해 compareTo 오버라이딩
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 좌표를 저장하는 배열로 번호와 인덱스를 통일시키려고 패딩
        int[][] pos = new int[1+N][2];
        for(int i=1 ; i<=N ; i++){
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }

        // 간선 배열을 선언하고 간선 정보 입력
        List<Edge> edges = new ArrayList<>();
        for(int i=1 ; i<N ; i++){
            for(int j=i+1 ; j<=N ; j++){
                edges.add(new Edge(i, j, Distance(pos[i], pos[j])));
            }
        }
        Collections.sort(edges);

        // 유니온 파인드를 위한 부모 배열 p 초기화
        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        double sum = 0;    // 통로 길이의 합
        int cnt = 0;    // 선택된 간선의 개수

        // 이미 연결된 통로에 대한 크루스칼 알고리즘 수행
        // 이미 연결된 통로는 cnt에만 영향을 미친다
        for(int i=0 ; i<M ; i++){
            int x = find(sc.nextInt());
            int y = find(sc.nextInt());
            if(x == y) continue;

            union(x, y);
            cnt++;
        }

        // 크루스칼 알고리즘으로 MST 완성
        for(Edge e : edges){
            // 이미 연결된 통로로 그래프의 모든 점이 연결될 경우 break
            // MST가 완성됐을 경우 break
            if(cnt == N-1) break;

            int x = find(e.x);
            int y = find(e.y);
            if(x == y) continue;

            union(x, y);
            sum += e.v;
            cnt++;
        }

        System.out.printf("%.2f", sum);    // 출력 양식

    }

    // 유니온 파인드의 부모 배열
    static int[] p;

    // 유니온 파인드의 find 메서드로 path compression 처리
    private static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // 유니온 파인드의 union 메서드
    private static void union(int x, int y){
        p[y] = x;
    }

    // 두 좌표의 거리를 구하는 메서드
    private static double Distance(int[] arr1, int[] arr2){
        int dx = arr1[0] - arr2[0];
        int dy = arr1[1] - arr2[1];

//        return Math.sqrt(dx*dx + dy*dy);    // 이렇게 하면 4%에서 틀립니다
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

}
