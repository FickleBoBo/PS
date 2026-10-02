package day_13.BOJ_3190;

import java.io.*;
import java.util.*;

public class Main {

    private static final int EMPTY = 0;
    private static final int APPLE = 1;
    private static final int SNAKE = 2;

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        char[] dArr = new char[1 + 10000];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            dArr[x] = c;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 1});
        map[0][0] = SNAKE;

        int ans = 0;
        for (int i = 1; i <= 10000; i++) {
            boolean isEnd = move(dq, dArr[i], N, map);
            if (isEnd) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    private static boolean move(Deque<int[]> dq, char rotate, int N, int[][] map) {
        int nr = dq.peekFirst()[0] + dr[dq.peekFirst()[2]];
        int nc = dq.peekFirst()[1] + dc[dq.peekFirst()[2]];
        int nd = dq.peekFirst()[2];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N) return true;
        if (map[nr][nc] == SNAKE) return true;

        if (rotate == 'L') dq.addFirst(new int[]{nr, nc, (nd - 1 + 4) % 4});
        else if (rotate == 'D') dq.addFirst(new int[]{nr, nc, (nd + 1 + 4) % 4});
        else dq.addFirst(new int[]{nr, nc, nd});

        if (map[nr][nc] != APPLE) {
            map[dq.peekLast()[0]][dq.peekLast()[1]] = EMPTY;
            dq.removeLast();
        }
        map[nr][nc] = SNAKE;

        return false;
    }

}
