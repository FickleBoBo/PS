package day_06.BOJ_G2_10775;

import java.io.*;

public class Main3 {

    static int[] p;

    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        p = new int[1+G];
        for(int i=1 ; i<=G ; i++) p[i] = i;

        int ans = 0;

        for(int i=0 ; i<P ; i++){

            // 비행기가 도킹 가능한 게이트를 바로 찾음
            int n = find(Integer.parseInt(br.readLine()));

            if(n == 0) break;

            // 도킹 가능한 게이트를 한칸 이동
            union(n-1, n);
            ans++;
        }

        System.out.println(ans);
    }
}
