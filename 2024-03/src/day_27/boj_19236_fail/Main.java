package day_27.BOJ_G2_19236_Fail;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				pq.add(new Fish(i, j, sc.nextInt(), sc.nextInt()));
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().num);
		}
		
	}
}

class Fish implements Comparable<Fish>{
	int r;
	int c;
	int num;
	int dir;
	
	Fish(int r, int c, int num, int dir){
		this.r = r;
		this.c = c;
		this.num = num;
		this.dir = dir;
	}

	@Override
	public int compareTo(Fish o) {
		return o.num;
	}
}