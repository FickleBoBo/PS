package day_12.BOJ_G3_16235_Fail;

import java.io.*;
import java.util.*;

// 나무 하나에 대해 x좌표, y좌표, 나이 3가지 정보를 알고 있어야 해서 인스턴스로 만드는게 쉬운듯
class Tree implements Comparable<Tree> {
    int x, y, age;

    public Tree(int x, int y, int age) {
        super();            // <- 이거는 왜있는지 모르겠음
        this.x = x;         // 나무 위치
        this.y = y;         // 나무 위치
        this.age = age;     // 나무 나이
    }

    @Override
    public int compareTo(Tree o) {    // 객체 정렬 암기 사항
        return this.age - o.age;
    }
}

public class Main {
    static int[] adj_x = { -1, -1, -1, 0, 0, 1, 1, 1 };    // 8방 탐색
    static int[] adj_y = { -1, 0, 1, -1, 1, -1, 0, 1 };    // 8방 탐색

    public static void main(String[] args) throws Exception {

        // step1 - 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][N + 1];             // 추가되는 양분의 양
        int[][] eat = new int[N + 1][N + 1];           // 양분
        Deque<Tree> tree_list = new LinkedList<>();    // 살아있는 나무 인스턴스를 관리할 디큐(size == 정답)

        // A[r][c] 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());    // 추가되는 양분의 양은 입력으로 주어짐
                eat[i][j] = 5;                                 // 초기 양분의 양은 5 고정
            }
        }

        // 나무 디큐에 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            tree_list.add(new Tree(x, y, tree_age));
        }

        // step2 - 돌리기
        while (K > 0) {
            Queue<Tree> die_tree_list = new LinkedList<>();    // 죽은 나무 큐(양분 퍼트리기 용)

            /* 봄
            *  나이가 어린 나무부터 양분을 먹고 양분을 못먹은 나무는 죽는다
            * */
            for (int i = 0; i < tree_list.size();) {    // 살아있는 나무 디큐를 돌면서
                Tree cur = tree_list.poll();            // 하나 꺼내서
                if (eat[cur.x][cur.y] >= cur.age) {     // 양분을 먹을 수 있는 조건이면
                    eat[cur.x][cur.y] -= cur.age;       // 양분 먹고(땅의 양분을 바꿈)
                    cur.age++;                          // 나이 하나 올리고
                    i++;
                    tree_list.add(cur);                 // 디큐에 추가해줌
                } else {
                    die_tree_list.add(cur);             // 양분을 못먹으면 죽은 나무 큐에 추가해줌
                }
            }

            /* 여름
            *  죽은 나무 큐를 돌며 죽은 자리에 양분을 추가
            * */
            for (Tree t : die_tree_list) {
                eat[t.x][t.y] += t.age / 2;
            }

            /* 가을
            *  나이가 5의 배수인 나무가 있으면 8방 탐색하며 새로운 나무를 심는다
            * */
            Queue<Tree> temp_list = new LinkedList<>();    // 새로운 나무 큐를 만듦
            for (Tree t : tree_list) {
                if (t.age % 5 == 0) {
                    temp_list.add(t);    // 나이가 5의 배수인 나무만 새로운 나무 큐에 담읆
                }
            }
            while (!temp_list.isEmpty()) {    // 나이가 5의 배수인 나무들에 대해서
                Tree t = temp_list.poll();    // 하나 꺼내고

                for (int i = 0; i < 8; i++) {    // 8방 탐색하며 자리가 있으면 기존 나무 디큐의 앞에 추가해줌
                    int next_x = t.x + adj_x[i];
                    int next_y = t.y + adj_y[i];
                    if (next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N) {
                        tree_list.addFirst(new Tree(next_x, next_y, 1));
                    }
                }
            }

            /* 겨울
            *  맵을 돌며 양분을 추가해줌
            * */
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    eat[i][j] += A[i][j];
                }
            }

            K--;    // 반복 횟수 -1
        }

        bw.write(tree_list.size() + "\n");
        bw.flush();
        bw.close();
    }
}