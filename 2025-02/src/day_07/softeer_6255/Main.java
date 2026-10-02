package day_07.Softeer_6255;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] message = br.readLine().toCharArray();
        char[] newMessage = makeNewMessage(message);

        // 구현의 편의를 위해 미리 J를 제외한 알파벳을 붙여서 키를 생성
        char[] key = (br.readLine() + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray();

        // 주어진 키를 변환한 표
        char[][] map = init(key);

        // key에 알파벳, value에 표에서의 위치를 저장한 맵
        Map<Character, int[]> posMap = init(map);

        for (int i = 0; i < newMessage.length; i += 2) {
            char c1 = newMessage[i];
            char c2 = newMessage[i + 1];

            int rowC1 = posMap.get(c1)[0];
            int colC1 = posMap.get(c1)[1];
            int rowC2 = posMap.get(c2)[0];
            int colC2 = posMap.get(c2)[1];

            // 규칙 1
            if (rowC1 == rowC2) sb.append(map[rowC1][(colC1 + 1) % 5]).append(map[rowC2][(colC2 + 1) % 5]);
            // 규칙 2
            else if (colC1 == colC2) sb.append(map[(rowC1 + 1) % 5][colC1]).append(map[(rowC2 + 1) % 5][colC2]);
            // 규칙 3
            else sb.append(map[rowC1][colC2]).append(map[rowC2][colC1]);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 주어진 메시지를 두 글자씩 나누는 로직 적용
    private static char[] makeNewMessage(char[] message) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < message.length - 1; i += 2) {
            char c1 = message[i];
            char c2 = message[i + 1];

            if (c1 != c2) {
                sb.append(c1).append(c2);
            } else {
                if (c1 == 'X') sb.append(c1).append('Q');
                else sb.append(c1).append('X');

                cnt++;
                i--;
            }
        }

        // 마지막에 한 글자가 남는 경우
        if ((message.length + cnt) % 2 == 1) sb.append(message[message.length - 1]).append('X');

        return sb.toString().toCharArray();
    }

    // 주어진 키를 표로 변환
    private static char[][] init(char[] key) {
        char[][] map = new char[5][5];
        boolean[] visited = new boolean[26];
        int idx = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                while (visited[key[idx] - 'A']) {
                    idx++;
                }

                map[i][j] = key[idx];
                visited[map[i][j] - 'A'] = true;
            }
        }

        return map;
    }

    // 알바벳의 위치를 저장한 맵 반환
    private static Map<Character, int[]> init(char[][] map) {
        Map<Character, int[]> posMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                posMap.put(map[i][j], new int[]{i, j});
            }
        }

        return posMap;
    }

}
