package day_05.BOJ_G3_1005_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++) {
        	String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            cost = new int[1+N];
            int idx = 1;
            while(st.hasMoreTokens()){
                cost[idx++] = Integer.parseInt(st.nextToken());
            }



            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<K ; i++){
                sb.append(br.readLine() + " ");
            }

            st = new StringTokenizer(sb.toString(), " ");

            adj = new int[1+N][1+N];
            while(st.hasMoreTokens()) {
            	int p = Integer.parseInt(st.nextToken());
            	int c = Integer.parseInt(st.nextToken());
            	adj[p][c]++;
            }
            


            int W = Integer.parseInt(br.readLine());


            // 데이터 잘 들어갔나 확인
//            System.out.printf("T : %d / N : %d / K : %d\n", T, N, K);
//            System.out.println("비용 배열 : " + Arrays.toString(cost));
//            System.out.println("인접 행렬");
//            for(int i=0 ; i<adj.length ; i++) {
//            	System.out.println(Arrays.toString(adj[i]));
//            }
            
            visited = new boolean[1+N];
//            BFS(W);

            DP = new int[1+N];
            ans = 0;
            DFS(W, cost[W]);
//            System.out.println(Arrays.toString(DP));
            
            int[][] tmp = new int[1+N][1+N];
            
//            for(int i=1 ; i<=N ; i++) {
//            	for(int j=1 ; j<=N ; j++) {
//            		
//            	}
//            }
//            
//            for(int i=1 ; i<=N ; i++) {
//            	for(int j=1 ; j<=N ; j++) {
//            		System.out.print(tmp[i][j] + " ");
//            	}
//            	System.out.println();
//            }
            
            System.out.println(ans);
        }
        
        

        br.close();
    }

    static int N;
    static int[][] adj;
    static boolean[] visited;
    static int[] cost;
    static int[] DP;
    static int ans;
    
    private static void DFS(int node, int sum) {
    	
//    	System.out.println(node);
    	
    	for(int i=1 ; i<=N ; i++) {
    		if(adj[i][node]==1) {
    			DFS(i, sum+cost[i]);
    		}
    	}
    	
    	ans = Math.max(ans, sum);
    	
    }

}
