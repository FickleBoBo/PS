package day_11.BOJ_G5_1717;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++) p[i] = i;

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            boolean flag = Integer.parseInt(st.nextToken()) == 0;
            int x = find(Integer.parseInt(st.nextToken()));
            int y = find(Integer.parseInt(st.nextToken()));

            if(flag){
                union(x, y);
            }
            else{
                if(x == y){
                    bw.write("YES\n");
                }
                else{
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
