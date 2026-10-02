package day_14.BOJ_G4_20040;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N];
        for(int i=0 ; i<N ; i++) p[i] = i;

        for(int i=1 ; i<=M ; i++){
            st = new StringTokenizer(br.readLine());

            int x = find(Integer.parseInt(st.nextToken()));
            int y = find(Integer.parseInt(st.nextToken()));

            if(x == y){
                System.out.println(i);
                return;
            }

            union(x, y);
        }

        System.out.println(0);
    }
}
