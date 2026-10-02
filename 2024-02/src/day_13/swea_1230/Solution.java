package day_13.SWEA_D3_1230;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {               // tc : 각각의 테스트 케이스

			int N = Integer.parseInt(sc.nextLine());     // N : 뭉치 속 암호문의 개수
			String[] Narr = sc.nextLine().split(" ");    // Narr : 암호문 배열(String으로 만들기)

			DoublyLinkedList list = new DoublyLinkedList();    // list : 자작 링크드리스트
			for (int i = 0; i < N; i++) {
				list.insert(Narr[i], list.size);               // 암호문을 링크드리스트에 채워준다
			}

			int M = Integer.parseInt(sc.nextLine());     // M : 명령어의 개수인데 나는 버림
			String[] Marr = sc.nextLine().split(" ");    // Marr : 명령어를 무지성으로 일단 받음

			for (int i = 0; i < Marr.length; i++) {

				if (Marr[i].equals("I")) {    // 삽입 명령 시
					int x = Integer.parseInt(Marr[i + 1]);
					int y = Integer.parseInt(Marr[i + 2]);
					for (int j = i + 2 + y; j >= i + 3; j--) {    // 이렇게 해줘야 새로 넣는게 뒤로 들어감
						list.insert(Marr[j], x);
					}
				} 
				else if (Marr[i].equals("D")) {    // 삭제 명령 시
					int x = Integer.parseInt(Marr[i + 1]);
					int y = Integer.parseInt(Marr[i + 2]);
					for (int j = 0; j < y; j++) {    // 그냥 횟수만큼 삭제
						list.delete(x);
					}
				} 
				else if (Marr[i].equals("A")) {    // 추가 명령 시
					int y = Integer.parseInt(Marr[i + 1]);
					for (int j = i + 2; j < i + 2 + y; j++) {    // I 명령 약간 응용
						list.insert(Marr[j], list.size);
					}
				}
			}
			System.out.printf("#%d ", tc);
			list.printList();
		}
		sc.close();
	}
}

class Node {    // 노드는 String data를 저장하며 양방향 연결

	String data;
	Node prev;
	Node next;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}

}

class DoublyLinkedList {    // 링크드리스트는 헤드와 테일에 빈 노드를 참조함

	int size = 0;
	Node head = new Node();
	Node tail = new Node();

	DoublyLinkedList() {
		head.next = tail;
		tail.prev = head;
	}

	void insert(String data, int idx) {    // 데이터를 원하는 인덱스에 삽입하는 메소드
		Node newNode = new Node(data);

		Node curr = head;
		while (idx-- >= 0) {
			curr = curr.next;
		}

		newNode.prev = curr.prev;
		newNode.next = curr;
		curr.prev.next = newNode;
		curr.prev = newNode;
		size++;
	}

	void delete(int idx) {    // 해당 인덱스의 데이터를 삭제하는 메소드

		Node curr = head;
		while (idx-- >= 0) {
			curr = curr.next;
		}

		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		size--;
	}

	void printList() {    // 링크드리스트 출력 메소드
		Node curr = head.next;
		for (int i = 0; i < 10; i++) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

}