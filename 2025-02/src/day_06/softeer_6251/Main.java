package day_06.Softeer_6251;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        // 왼쪽 부하 직원이 올린 업무들
        Queue<Integer> left = new ArrayDeque<>();
        // 오른쪽 부하 직원이 올린 업무들
        Queue<Integer> right = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()) + 1;
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 완전이진트리면서 말단 직원과 부서장까지 올라가는 거리가 동일하면 포화이진트리(부서장을 1로 설정)
        Node[] tree = new Node[1 << H];
        for (int i = 0; i < (1 << H); i++) {
            tree[i] = new Node();
        }

        // 가장 왼쪽 말단 직원의 번호
        int leafStart = 1 << (H - 1);
        // 가장 오른쪽 말단 직원의 번호
        int leafEnd = (1 << H) - 1;

        // 말단 직원에게 대기하는 업무를 넣어줌
        // 상사의 왼쪽 말단 직원이면 그냥 왼쪽 큐에, 오른쪽 말단 직원이면 오른쪽 큐에 삽입
        for (int i = leafStart; i <= leafEnd; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (i % 2 == 0) tree[i].left.add(Integer.parseInt(st.nextToken()));
                else tree[i].right.add(Integer.parseInt(st.nextToken()));
            }
        }

        int sum = 0;
        for (int day = 1; day <= R; day++) {

            // 부서장이 일 처리
            if (day % 2 == 1 && !tree[1].left.isEmpty()) sum += tree[1].left.remove();
            else if (day % 2 == 0 && !tree[1].right.isEmpty()) sum += tree[1].right.remove();

            // 중간 직원이 일 처리
            for (int h = 2; h < H; h++) {

                // 현재 높이에서 가장 왼쪽 중간 직원의 번호
                int left = 1 << (h - 1);
                // 현재 높이에서 가장 오른쪽 중간 직원의 번호
                int right = (1 << h) - 1;

                for (int i = left; i <= right; i++) {

                    // 홀수일이면서 왼쪽 부하직원이 준 업무가 있는 경우
                    if (day % 2 == 1 && !tree[i].left.isEmpty()) {
                        int task = tree[i].left.remove();

                        // 번호가 짝수인 직원은 상사에게 왼쪽 부하 직원
                        if (i % 2 == 0) tree[i / 2].left.add(task);
                        // 번호가 홀수인 직원은 상사에게 오른쪽 부하 직원
                        else tree[i / 2].right.add(task);
                    }
                    // 짝수일이면서 오른쪽 부하직원이 준 업무가 있는 경우
                    else if (day % 2 == 0 && !tree[i].right.isEmpty()) {
                        int task = tree[i].right.remove();

                        // 번호가 짝수인 직원은 상사에게 왼쪽 부하 직원
                        if (i % 2 == 0) tree[i / 2].left.add(task);
                        // 번호가 홀수인 직원은 상사에게 오른쪽 부하 직원
                        else tree[i / 2].right.add(task);
                    }
                }
            }

            // 말단 직원이 일 처리
            for (int i = leafStart; i <= leafEnd; i++) {
                // 번호가 짝수인 직원은 상사에게 왼쪽 부하 직원
                if ((i % 2 == 0) && !tree[i].left.isEmpty()) tree[i / 2].left.add(tree[i].left.remove());
                // 번호가 홀수인 직원은 상사에게 오른쪽 부하 직원
                else if ((i % 2 == 1) && !tree[i].right.isEmpty()) tree[i / 2].right.add(tree[i].right.remove());
            }
        }

        System.out.println(sum);
    }
}
