package day_03.BOJ_G4_11404;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1000000000;

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        int[][] floyd = new int[1+N][1+N];
        for(int i=0 ; i<=N ; i++){
            Arrays.fill(floyd[i], INF);
            floyd[i][i] = 0;
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            floyd[a][b] = Math.min(floyd[a][b], c);
        }

        for(int k=1 ; k<=N ; k++){
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                if(floyd[i][j] != INF){
                    bw.write(floyd[i][j] + " ");
                }
                else{
                    bw.write(0 + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
