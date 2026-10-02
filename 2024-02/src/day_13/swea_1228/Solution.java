package day_13.SWEA_D3_1228;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {                        // tc : 각각의 테스트 케이스
			
			int N = Integer.parseInt(sc.nextLine());           // N : 암호문의 길이
			String[] password = sc.nextLine().split(" ");      // password : 원본 암호문
			
			SinglyLinkedList list = new SinglyLinkedList();    // list : 자작 단방향 링크드리스트
			for(int i=0 ; i<N ; i++) {
				list.insert(password[i], list.size);     // 원본 암호문을 링크드리스트에 넣음
			}
			
			int M = Integer.parseInt(sc.nextLine());     // M : 명령어의 개수인데 안 쓸 예정
			String[] arr = sc.nextLine().split(" ");     // arr : 명령어 분해
			
			for(int i=0 ; i<arr.length ; i++) {
				if(arr[i].equals("I")) {                 // 삽입 신호 발견하면
					int x = Integer.parseInt(arr[i+1]);
					int y = Integer.parseInt(arr[i+2]);
					for(int j=i+2+y ; j>=i+3 ; j--) {    // 같은 위치에는 역순으로 넣어줘야 순서 유지됨
						list.insert(arr[j], x);
					}
				}
			}
			System.out.printf("#%d ", tc);
			list.printList();
		}
		sc.close();
	}
}

class Node{    // 단방향 연결용 노드
	
	String data;
	Node next;
	
	Node(){}
	
	Node(String data){
		this.data = data;
	}
}

class SinglyLinkedList{    // 단방향 링크드 리스트
	
	int size = 0;
	Node head;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	void insert(String data, int idx) {    // 원하는 인덱스에 data 삽입(head를 0이라 가정)
		Node newNode = new Node(data);
		
		Node curr = head;
		while(idx-->0) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
		size++;
	}
	
	void printList() {    // 앞에서부터 10개 출력하는 메소드
		Node curr = head.next;
		for(int i=1 ; i<=10 ; i++) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}