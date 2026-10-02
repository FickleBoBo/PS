package day_11.SWEA_D3_1225;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){

            int N = sc.nextInt();
            Queue queue = new Queue();    // queue : 구현한 Queue 자료구조 사용
            for(int i=0 ; i<8 ; i++){     // 비밀번호 8개 queue에 넣음
                queue.offer(sc.nextInt());
            }

            out:
            while(true){                                   // 조건을 만족할 때까지 무한반복
                for(int i=1 ; i<=5 ; i++){                 // 한 사이클 수행
                    if(queue.peek() > i){                  // peek로 수행 가능한지 체크
                        queue.offer(queue.poll()-i);    // 빼자마자 넣는게 포인트
                    }
                    else{
                        queue.poll();    // 하나 빼고 0 넣어서 완료하기
                        queue.offer(0);
                        break out;       // 반복문 완전히 빠져나오기
                    }
                }
            }

            System.out.printf("#%d ", N);    // 무지성 출력
            while(!queue.isEmpty()){
                System.out.printf("%d ", queue.poll());
            }
            System.out.println();
        }
        sc.close();
    }
}

class Queue{    // 배열을 이용한 원형큐로 구현

    int size = 1 + 8 + 5;    // 앞의 1은 % 연산의 편리함을 위한 더미, 8은 비밀번호의 자릿수에 맞춤, 5는 한 사이클을 저장해서 데이터 오염 방지
    int[] queue = new int[size];
    int front = 0;
    int rear = 0;

    int peek(){
        return queue[front % 13 + 1];
    }

    void offer(int N){
        rear = rear % 13 + 1;
        queue[rear] = N;
    }

    int poll(){
        front = front % 13 + 1;
        return queue[front];
    }

    boolean isEmpty(){    // 비밀번호 사이클 구조상 8칸 차이가 유지되므로 문제없음
        return front == rear;
    }
}
