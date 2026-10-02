package day_19.BOJ_S2_11724;

import java.io.*;
import java.util.*;

public class Main_UnionFind {

    // 부모 배열
    static int[] p;

    // find-set
    private static int find(int x){
        if(x == p[x]) return p[x];
        return p[x] = find(p[x]);
    }

    // union-set
    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // make-set
        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = find(Integer.parseInt(st.nextToken()));
            int B = find(Integer.parseInt(st.nextToken()));

            union(A, B);
        }

        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            if(i == p[i]) cnt++;    // 최고 조상이 자기 자신(그룹 대표)이면 카운트
        }

        System.out.println(cnt);
    }

}
