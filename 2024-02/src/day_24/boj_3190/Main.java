package day_24.BOJ_G4_3190;

import java.util.*;

public class Main {

    static int[][] map;                                              // map : 맵 정보를 담을 2차원 배열(빈곳: 0 / 사과가 있는 곳: 1 / 뱀이 있는 곳: -1)
    static int N;                                                    // N : 맵의 크기
    static Deque<Integer> snakeXposDeque = new LinkedList<>();       // 뱀의 x좌표 정보들을 담을 디큐
    static Deque<Integer> snakeYposDeque = new LinkedList<>();       // 뱀의 y좌표 정보들을 담을 디큐
    static Queue<Integer> rotationTimeQueue = new LinkedList<>();    // 회전하는 시간을 담을 큐(시간순으로 주어지므로)
    static Queue<String> rotationQueue = new LinkedList<>();         // 회전하는 방향을 담을 큐
    static int[] dr = {-1, 0, 1, 0};                                 // 상 우 하 좌 델타배열
    static int[] dc = {0, 1, 0, -1};                                 // 상 우 하 좌 델타배열
    static int dir = 1;                                              // 뱀은 3시 방향으로 출발하는 것이 기본값

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. 맵 세팅
        N = sc.nextInt();
        map = new int[N][N];

        // 2. 사과 세팅
        int K = sc.nextInt();
        for(int i=0 ; i<K ; i++){
            map[sc.nextInt()-1][sc.nextInt()-1] = 1;    // 사과가 1행 1열은 없다는 조건에서 1행 1열이 시작이라 -1 해줌...(이거땜에 20분 씀)
        }

        // 3. 회전 값 세팅(한번에 하고 싶었는데 배열을 원소로 받는건 어려웠음)
        int L = sc.nextInt();
        for(int i=0 ; i<L ; i++){
            rotationTimeQueue.offer(sc.nextInt());    // 시간만 넣어줌
            rotationQueue.offer(sc.next());           // 방향만 넣어줌
        }

        // 4. 뱀 세팅
        snakeXposDeque.add(0);    // (0, 0)에 놓여 있음
        snakeYposDeque.add(0);    // (0, 0)에 놓여 있음
        map[0][0] = -1;           // 뱀이 놓인 칸은 -1

        // 시작
        int sec = 0;
        while(!gameOver(sec)){    // 뱀이 이동 가능한동안 반복

//            printMap(sec);    // 점검용

            moveSnake();    // 뱀 이동
            sec++;
        }

        System.out.println(sec+1);    // 조건 맞춰서 1 더해줬는데, 뱀이 이동불가능하면 현재 sec에서 반복문이 종료돼서 필요한듯

        sc.close();
    }

    // 뱀이 이동할 다음 칸을 정하고 이동 가능하면 true, 이동 불가능하면 false 리턴
    static boolean gameOver(int sec){
        // 회전을 먼저 고려해야함(이걸 moveSnake() 메소드에 넣어서 구현 안됐음)
        if((!rotationTimeQueue.isEmpty()) && (rotationTimeQueue.peek() == sec)){    // 회전 입력 sec(값)이 남아있고 && 회전 입력 sec이 주어진 sec이랑 같으면
            if(rotationQueue.peek().equals("D")){    // 오른쪽 회전이면
                dir = (dir+5) % 4;                   // 인덱스 한칸 오른쪽으로(이렇게 하면 배열을 원형으로 사용가능)
            }
            else{                                    // 왼쪽 회전이면
                dir = (dir+3) % 4;                   // 인덱스 한칸 왼쪽으로(이렇게 하면 배열을 원형으로 사용가능)
            }
            rotationTimeQueue.poll();                // 썼으면 poll() 해서 비워주기
            rotationQueue.poll();                    // 썼으면 poll() 해서 비워주기
        }

        int nx = snakeXposDeque.peekFirst() + dr[dir];    // 뱀의 머리가 위치할 새로운 x좌표
        int ny = snakeYposDeque.peekFirst() + dc[dir];    // 뱀의 머리가 위치할 새로운 y좌표
        if((nx<0) || (nx==N) || (ny<0) || (ny==N) ||      // 새로운 좌표가 map의 범위를 벗어나거나 뱀 자신을 만나는 좌표일 경우 게임 종료
                (map[nx][ny]==-1)) return true;
        return false;
    }

    // 뱀을 움직이는 메서드
    static void moveSnake(){

        int nx = snakeXposDeque.peekFirst() + dr[dir];    // 뱀의 머리가 위치할 새로운 x좌표
        int ny = snakeYposDeque.peekFirst() + dc[dir];    // 뱀의 머리가 위치할 새로운 y좌표

        snakeXposDeque.addFirst(nx);    // 뱀의 머리 앞에 추가
        snakeYposDeque.addFirst(ny);    // 뱀의 머리 앞에 추가
        if(map[nx][ny] != 1){           // 새로운 좌표가 사과가 아닐 경우 뱀의 꼬리를 움직여줘야 한다
            map[snakeXposDeque.peekLast()][snakeYposDeque.peekLast()] = 0;    // map의 꼬리 좌표를 0으로 갱신
            snakeXposDeque.pollLast();    // 꼬리 아웃
            snakeYposDeque.pollLast();    // 꼬리 아웃
        }
        map[nx][ny] = -1;    // map의 머리 좌표를 -1로 갱신
    }

    // 잘되나 확인용 메서드(보면 재밌음)
    static void printMap(int sec){
        System.out.printf("%d초 / 방향: %d 머리: (%d, %d), 꼬리: (%d, %d)\n", sec, dir, snakeXposDeque.peekFirst(), snakeYposDeque.peekFirst(), snakeXposDeque.peekLast(), snakeYposDeque.peekLast());
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                System.out.printf("%3d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
