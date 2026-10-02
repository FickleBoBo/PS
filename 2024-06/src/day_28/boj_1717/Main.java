package day_28.BOJ_G5_1717;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[1+N];

        // make-set
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            boolean flag = st.nextToken().equals("0");    // 연산의 종류 구분
            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if(flag){
                union(a, b);
            }
            else{
                if(a == b){
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
