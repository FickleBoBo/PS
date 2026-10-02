package day_25.BOJ_14226;

import java.io.*;
import java.util.*;

public class Main {

    private static class Emoji {
        int screen;
        int clipBoard;

        public Emoji(int screen, int clipBoard) {
            this.screen = screen;
            this.clipBoard = clipBoard;
        }
    }

    private static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        int time = bfs(S);
        System.out.println(time);
    }

    private static int bfs(int target) {
        Queue<Emoji> q = new ArrayDeque<>();
        q.add(new Emoji(1, 0));

        // 행은 화면에 있는 이모티콘 수, 열은 클립보드에 있는 이모티콘 수에 대한 방문체크
        boolean[][] visited = new boolean[1 + MAX][1 + MAX];
        visited[1][0] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Emoji emoji = q.remove();
                if (emoji.screen == target) return dist;

                // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
                if ((emoji.screen <= MAX) && !visited[emoji.screen][emoji.screen]) {
                    q.add(new Emoji(emoji.screen, emoji.screen));
                    visited[emoji.screen][emoji.screen] = true;
                }

                // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
                if ((emoji.screen + emoji.clipBoard <= MAX) && !visited[emoji.screen + emoji.clipBoard][emoji.clipBoard]) {
                    q.add(new Emoji(emoji.screen + emoji.clipBoard, emoji.clipBoard));
                    visited[emoji.screen + emoji.clipBoard][emoji.clipBoard] = true;
                }

                // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
                if ((emoji.screen > 0) && !visited[emoji.screen - 1][emoji.clipBoard]) {
                    q.add(new Emoji(emoji.screen - 1, emoji.clipBoard));
                    visited[emoji.screen - 1][emoji.clipBoard] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
