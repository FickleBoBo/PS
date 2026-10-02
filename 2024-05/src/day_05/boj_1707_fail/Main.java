package day_05.BOJ_G4_1707_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<E ; i++){
                sb.append(br.readLine() + " ");
            }

            StringTokenizer st = new StringTokenizer(sb.toString(), " ");

            List<Integer>[] adj = new ArrayList[1+V];
            for(int i=1 ; i<=V ; i++){
                adj[i] = new ArrayList<>();
            }

            while(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                adj[y].add(x);
            }

            int cnt = V;
            for(int i=1 ; i<=V ; i++){
                boolean[] visited = new boolean[1+V];
                visited[i] = true;
                for(int j=0 ; j<adj[i].size() ; j++){
                    visited[adj[i].get(j)] = true;
                }

                int tmp = 0;
                System.out.println(Arrays.toString(visited));
                for(int j=1 ; j<=V ; j++){
                    if(!visited[j]) tmp++;
                }
                System.out.println(tmp);
                cnt = Math.min(cnt, tmp);
            }

            if(cnt > 1) System.out.println("NO");
            else System.out.println("YES");

        }

        br.close();
    }
}
