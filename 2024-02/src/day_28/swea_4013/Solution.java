package day_28.SWEA_모의SW역량테스트_4013;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int K = Integer.parseInt(sc.nextLine());

			// 자석들의 데이터 저장
			String[][] magnet = {
					sc.nextLine().split(" "), 
					sc.nextLine().split(" "), 
					sc.nextLine().split(" "), 
					sc.nextLine().split(" ")
			};

			// 12시, 9시, 3시 순서로 자석별 인덱스 저장(모듈러 연산으로 계산 예정)
			int[][] magnetIdx = {
					{0, 6, 2}, 
					{0, 6, 2}, 
					{0, 6, 2}, 
					{0, 6, 2}
			};
			
			
			for(int n=0 ; n<K ; n++) {
				String[] input = sc.nextLine().split(" ");
				int choice = Integer.parseInt(input[0])-1;    // choice : 돌릴 자석의 번호

				// 회전 방향은 둘 중 하나임
				int[] turnDirection;
				if(((choice%2==1) && (Integer.parseInt(input[1]) == 1)) || 
						(choice%2==0) && (Integer.parseInt(input[1]) == -1)) {
					turnDirection = new int[]{1, -1, 1, -1};
				}
				else {
					turnDirection = new int[]{-1, 1, -1, 1};
				}
				boolean[] turnMagnet = checkMagnetConnetion(choice, magnet, magnetIdx);    // 자석의 연결관계를 통해 돌릴 자석들을 true로 반환
				
				for(int i=0 ; i<4 ; i++) {
					if(turnMagnet[i]) {    // 돌릴 자석들을
						magnetIdx = turnMagnet(turnDirection[i], i, magnetIdx);    // 돌려줌
					}
				}
			}
			
			// 양식에 맞게 출력
			int ans = 0;
			if(magnet[0][magnetIdx[0][0]].equals("1")) ans = ans + 1;
			if(magnet[1][magnetIdx[1][0]].equals("1")) ans = ans + 2;
			if(magnet[2][magnetIdx[2][0]].equals("1")) ans = ans + 4;
			if(magnet[3][magnetIdx[3][0]].equals("1")) ans = ans + 8;
			System.out.printf("#%d %d\n", tc, ans);
			
			
			
//			for(int i=0 ; i<4 ; i++) {
//				for(int j=0 ; j<3 ; j++) {
//					System.out.print(magnetIdx[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			
		}
		sc.close();
	}

	// 자석을 주어진 방향으로 돌리고 인덱스 갱신해서 리턴
	static int[][] turnMagnet(int dir, int magNum , int[][] magIdx) {
		magIdx[magNum][0] = (magIdx[magNum][0] + 8 + dir) % 8;
		magIdx[magNum][1] = (magIdx[magNum][1] + 8 + dir) % 8;
		magIdx[magNum][2] = (magIdx[magNum][2] + 8 + dir) % 8;
		return magIdx;
	}

	// 자석의 연결관계를 파악해서 맞물려 돌아가는 자석을 true, 아닌 자석은 false로 boolean 배열로 리턴
	static boolean[] checkMagnetConnetion(int choice, String[][] mag, int[][] magIdx) {
		
		boolean[] tmp = new boolean[4];
		tmp[choice] = true;
		
		for(int i=choice ; i<mag.length-1 ; i++) {
			if(!(mag[i][magIdx[i][2]].equals(mag[i+1][magIdx[i+1][1]]))) {
				tmp[i+1] = true;
			}
			else {
				break;
			}
		}
		
		for(int i=choice ; i>0 ; i--) {
			if(!(mag[i][magIdx[i][1]].equals(mag[i-1][magIdx[i-1][2]]))) {
				tmp[i-1] = true;
			}
			else {
				break;
			}
		}
		return tmp;
	}
	
}
