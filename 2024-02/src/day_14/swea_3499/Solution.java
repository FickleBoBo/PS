package day_14.SWEA_D3_3499;

import java.util.Scanner;

class Node{    // String data를 받을 노드
	String data;
	Node left;
	Node right;
	
	Node(){}    // 트리에서 root 땜에 만들어줘야 함
	
	Node(String data){
		this.data = data;
	}
}

class Tree{    // 트리 자료구조 클래스
	
	Node root = new Node();
	
	Tree(){}
	
	void addLeft(String data) {    // 왼쪽에 추가하는 메소드
		Node newNode = new Node(data);
		
		Node curr = root;    // root부터 왼쪽으로 넣을 곳 찾음
		while(curr.left != null) {
			curr = curr.left;
		}
		curr.left = newNode;
	}
	
	void addRight(String data) {    // 오른쪽에 추가하는 메소드
		Node newNode = new Node(data);
		
		Node curr = root;    // root부터 오른쪽으로 넣을 곳 찾음
		while(curr.right != null) {
			curr = curr.right;
		}
		curr.right = newNode;
	}
	
	void printTree() {    // tree를 root부터 높이 순서로 출력
		Node currL = root;
		Node currR = root;
		while(currL.left != null) {    // 왼쪽에 자식있으면 반복
			System.out.print(currL.left.data + " ");
			currL = currL.left;    // 위치 갱신
			if(currR.right != null) {    // 오른쪽은 자식이 없을 수 있어서 필요함
				System.out.print(currR.right.data + " ");
				currR = currR.right;    // 위치 갱신
			}
		}
		System.out.println();
	}
}

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {              // tc : 각각의 테스트 케이스
			
			Tree tree = new Tree();                       // tree : 자작 트리(^ 모양으로 넣을 예정)
			int N = Integer.parseInt(sc.nextLine());      // N : 카드의 수
			String[] input = sc.nextLine().split(" ");    // input : 카드를 String배열로 받을 예정
			
			for(int i=0 ; i<N ; i++) {
				if(i<(N+1)/2) {                 // (N+1)/2 이렇게 해주면 홀짝 한번에 됨
					tree.addLeft(input[i]);     // 카드 덱 앞부분은 왼쪽 자식으로 쭉 이어줌
				}
				else {
					tree.addRight(input[i]);    // 카드 덱 뒷부분은 오른쪼 자식으로 쭉 이어줌
				}
			}
			System.out.printf("#%d ", tc);      // 앞에 #문제번호
			tree.printTree();                   // tree 출력
		}
		sc.close();    // 습관적 close
	}
}
