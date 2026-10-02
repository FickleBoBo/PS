package day_04.BOJ_1744;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1 보다 큰 정수만 담는 우선순위 큐
        PriorityQueue<Integer> pos_pq = new PriorityQueue<>();

        // 0 이하인 정수만 담는 우선순위 큐
        PriorityQueue<Integer> neg_pq = new PriorityQueue<>();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) pos_pq.add(num);
            else if (num == 1) sum += num;
            else neg_pq.add(num);
        }

        // 0 이하인 정수는 작은 수부터 최대한 짝을 맞추면 됨
        while (!neg_pq.isEmpty()) {
            int num1 = neg_pq.remove();

            if (neg_pq.isEmpty()) {
                sum += num1;
                break;
            }

            int num2 = neg_pq.remove();

            sum += num1 * num2;
        }

        // 1 보다 큰 정수는 큰 수부터 최대한 짝을 맞추면 됨
        if (pos_pq.size() % 2 == 1) sum += pos_pq.remove();

        while (!pos_pq.isEmpty()) {
            int num1 = pos_pq.remove();
            int num2 = pos_pq.remove();
            sum += num1 * num2;
        }

        System.out.println(sum);
    }
}
