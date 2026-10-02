package day_28.BOJ_G4_20040;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 유니온 파인드 알고리즘의 부모 배열
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

        p = new int[N];

        // make-set
        for(int i=1 ; i<N ; i++){
            p[i] = i;
        }

        int ans = 0;

        for(int i=1 ; i<=M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if(a == b){
                ans = i;
                break;
            }

            union(a, b);
        }

        System.out.println(ans);
    }
}
