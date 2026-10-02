package day_07.BOJ_1963;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Set<Integer> primes = getPrimes();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = bfs(primes, start, end);

            if (result >= 0) sb.append(result).append("\n");
            else sb.append("Impossible\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(Set<Integer> primes, int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[10000];
        visited[start] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int item = q.poll();
                if (item == end) return dist;

                for (int j = 0; j < 10; j++) {
                    int num1 = j * 1000 + item % 1000;
                    if (primes.contains(num1) && !visited[num1]) {
                        q.offer(num1);
                        visited[num1] = true;
                    }

                    int num2 = item / 1000 * 1000 + j * 100 + item % 100;
                    if (primes.contains(num2) && !visited[num2]) {
                        q.offer(num2);
                        visited[num2] = true;
                    }

                    int num3 = item / 100 * 100 + j * 10 + item % 10;
                    if (primes.contains(num3) && !visited[num3]) {
                        q.offer(num3);
                        visited[num3] = true;
                    }

                    int num4 = item / 10 * 10 + j;
                    if (primes.contains(num4) && !visited[num4]) {
                        q.offer(num4);
                        visited[num4] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }

    private static Set<Integer> getPrimes() {
        boolean[] isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 1000; i < 10000; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

}
