package day_01.BOJ_G3_1005_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			char[] input = br.readLine().toCharArray();
			int N = Character.getNumericValue(input[0]);
			int K = Character.getNumericValue(input[2]);

			sb = new StringBuilder();
			for(int i=0 ; i<=K ; i++) {
				sb.append(br.readLine() + " ");
			}

			st = new StringTokenizer(sb.toString(), " ");

			int[][] adj = new int[N+1][N+1];
			int[] inDegree = new int[N+1];
			int[] weight = new int[N+1];

			for(int i=1 ; i<=N ; i++){
				weight[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println("weight: " + Arrays.toString(weight));

			while(st.hasMoreTokens()) {
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				adj[X][Y]++;
				inDegree[Y]++;
			}
//			System.out.println("adj");
//			for(int i=1 ; i<=N ; i++){
//				System.out.println(Arrays.toString(adj[i]));
//			}
//			System.out.println("inDegree: " + Arrays.toString(inDegree));

			int W = Integer.parseInt(br.readLine());
//			System.out.println("W: " + W);


			int minTime = 0;
			Queue<Integer> topoSort = new LinkedList<>();
			for(int i=1 ; i<=N ; i++){
				if(inDegree[i]==0) topoSort.offer(i);
			}

			while(!topoSort.isEmpty()){
				int item = topoSort.poll();
				if(item==W) break;

				for(int i=1 ; i<=N ; i++){
					if(adj[item][i] != 0){
						inDegree[i]--;
						if(inDegree[i]==0){
							minTime += weight[i];
						}
					}
				}
			}

			System.out.println(minTime);

		}
		
		br.close();
	}
}
