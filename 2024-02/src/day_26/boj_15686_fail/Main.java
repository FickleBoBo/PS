package day_26.BOJ_G5_15686_Fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	// 각각의 치킨집과 다른 모든 집과의 치킨 거리의 합 중 최댓값인 치킨집 색출
	// 반례 찾아보니까 이게 무지성 최댓값을 찾으면 안됨
	/*
	* 2 1 0 1 2
	* 0 0 0 0 0
	* 0 0 2 0 0
	* 0 0 0 0 0
	* 2 1 0 1 2
	* 답 : 4 <- 이거 안됨
	* */
	static int maxChickenDist(int[][] arr) {
		int[] distSum = new int[arr[0].length];
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[0].length ; j++) {
				distSum[j] += arr[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		for(int i=0 ; i<distSum.length ; i++) {
			if(max <= distSum[i]) {
				max = distSum[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] city = new int[N][N];
		List<int[]> home = new ArrayList<int[]>();       // 집의 좌표 넣기
		List<int[]> chicken = new ArrayList<int[]>();    // 치킨집의 좌표 넣기
		
		// 도시 정보 받으면서 집과 치킨집 좌표 따로 저장
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				city[i][j] = sc.nextInt();
				int[] tmp = {i, j};
				if(city[i][j] == 1) home.add(tmp);
				if(city[i][j] == 2) chicken.add(tmp);
			}
		}
		
		// 각각의 치킨거리를 dist 배열에 저장
		int[][] dist = new int[home.size()][chicken.size()];
		for(int i=0 ; i<home.size() ; i++) {
			for(int j=0 ; j<chicken.size() ; j++) {
				dist[i][j] = Math.abs(home.get(i)[0]-chicken.get(j)[0]) +  Math.abs(home.get(i)[1]-chicken.get(j)[1]);
			}
		}
		
		// 치킨집 빼주기
		while(M < chicken.size()) {
			int pop = maxChickenDist(dist);
			for(int i=0 ; i<dist.length ; i++) {
				dist[i][pop] = -1;
			}
			M++;
		}
		
		// 출력
		int ans = 0;
		for(int i=0 ; i<home.size() ; i++) {
			int tmp = Integer.MAX_VALUE;
			for(int j=0 ; j<chicken.size() ; j++) {
				if(dist[i][j] > 0) {
					tmp = tmp > dist[i][j] ? dist[i][j] : tmp;
				}
			}
			ans += tmp;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
