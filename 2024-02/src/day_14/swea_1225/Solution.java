package day_14.SWEA_D3_1225;

import java.util.Scanner;

class Node{        // 비밀번호 하나를 담을 노드
	int data;      // data : 비밀번호
	Node child;    // 자식 노드 하나만 쓸거임
	
	Node(){}
	
	Node(int data){
		this.data = data;
	}
}



class Tree{    // 비밀번호 8자리를 담을 트리 자료구조
	Node root = new Node();
	
	Tree(){}
	
	void addChild(int data) {    // 비밀번호를 트리에 옮길 때 쓸 메소드
		Node newNode = new Node(data);
		
		Node curr = root;
		while(curr.child != null) {
			curr = curr.child;
		}
		curr.child = newNode;
	}
	
	int lastData() {    // 트리의 잎사귀 노드의 비밀번호 추출 메소드(비밀번호에서 마지막 자리)
		Node curr = root;
		while(curr.child != null) {
			curr = curr.child;
		}
		return curr.data;
	}
	
	void move(int N) {    // root에 연결된 노드를 잎사귀 노드의 자식 노드로 옮겨주는 메소드
		Node newnode = new Node(root.child.data - N);    // 새로 만들어야 함
		Node curr = root;
		while(curr.child != null) {
			curr = curr.child;
		}
		curr.child = newnode;
		root.child = root.child.child;
	}
	
	void printTree() {    // root의 자식 노드부터 잎사귀 노드까지 출력
		Node curr = root;
		while(curr.child != null) {
			curr = curr.child;
			if(curr.data >= 0) System.out.print(curr.data + " ");
			else System.out.print(0 + " ");
		}
		System.out.println();
	}
	
}



public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {    // tc : 각각의 테스트 케이스
			Tree tree = new Tree();

			sc.nextInt();                       // 더미 숫자 하나 받아줌
			for(int i=0 ; i<8 ; i++) {          // 비밀번호 순서대로 받아서 트리에 저장
				tree.addChild(sc.nextInt());    // 자식이 하나인 트리라 사실상 선형 자료구조
			}
			
			int n = 1;
			while(tree.lastData()>0) {    // 종료 조건
				tree.move(n);             // 계속 빼면서 옮겨줌
				if(++n>5) {
					n=n%5;                // n이 1 ~ 5 순환하도록 해줌
				}
			}
			System.out.printf("#%d ", tc);
			tree.printTree();
		}
		sc.close();
	}
}
