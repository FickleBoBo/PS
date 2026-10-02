package day_26.BOJ_S3_1966;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> q;
	static int N;
	static int M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1 ; tc<=T ; tc++){
			N = sc.nextInt();
			M = sc.nextInt();
			q = new LinkedList<>();
			for(int i=0 ; i<N ; i++){
				q.add(sc.nextInt());
			}

			int cnt = 1;
			int idx = M;

			while(!((idx==0) && (q.get(0)==maxNum()))){
				if(q.get(0)==maxNum()){
					q.remove(0);
					N--;
					idx--;
					cnt++;
				}
				else{
					q.add(q.get(0));
					q.remove(0);
					idx = (idx-1+N) % N;
				}
			}

			System.out.println(cnt);

		}
		sc.close();
	}

	private static int maxNum(){
		int max = -1;
		for(int i=0 ; i<N ; i++){
			max = Math.max(max, q.get(i));
		}
		return max;
	}

}
