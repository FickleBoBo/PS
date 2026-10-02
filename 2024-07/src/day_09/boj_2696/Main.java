package day_09.BOJ_G2_2696;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st;

        // T : 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        // T번 반복
        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());    // N : 수열의 크기

            // 입력이 10개씩 개행이라 그냥 StringBuilder로 받아줌
            sb = new StringBuilder();
            for(int i=0 ; i<=N/10 ; i++) sb.append(br.readLine()).append(" ");

            // 공백으로 쪼개기
            st = new StringTokenizer(sb.toString());

            // pq1은 Integer를 역순으로 정렬하는 우선순위 큐(최대힙)
            // pq2은 Integer를 정렬하는 우선순위 큐(최소힙)
            // 의도는 pq1의 peek는 최대 원소, pq2의 peek는 최소 원소를 가리키게 하는 것으로
            // { 중앙값보다 작은 애들 모음 } { 중앙값, 중앙값보다 큰 애들 모음} 이런 구조로 만들어서 pq2의 peek로 중앙값을 찾는게 목표
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());    // 생성자에 이거 넣으면 역순 정렬
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            int cnt = 0;    // 10개마다 개행해야해서 cnt로 개수 셈

            // 아래 while문에서 우선순위 큐가 비어있을 때 조건 처리하기 귀찮아서 그냥 하나 넣고 시작
            pq2.offer(Integer.parseInt(st.nextToken()));

            // 입력 받을때 빌더 썼으니까 다시 만들어주고
            sb = new StringBuilder();

            // 출력할 중앙값의 개수는 정해져 있음
            sb.append(N / 2 + 1).append("\n");
            sb.append(pq2.peek()).append(" ");
            cnt++;

            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());

                // pq1과 pq2의 크기가 같으면 pq2.peek()에 중앙값을 위치시켜야하니까
                // pq1에서 제일 큰 애보다 n이 작으면 pq1에서 제일 큰 애 pq2에 넣고 n을 pq1에 넣어줌
                // pq1에서 제일 큰 애보다 n이 크면 그냥 pq2에 넣으면 됨
                if(pq1.size() == pq2.size()){
                    if(pq1.peek() > n){
                        pq2.offer(pq1.poll());
                        pq1.offer(n);
                    }
                    else{
                        pq2.offer(n);
                    }

                    // pq2가 pq1보다 커진 순간이 홀수번째
                    sb.append(pq2.peek());
                    cnt++;

                    // 출력 양식 맞추기
                    if(cnt % 10 == 0) sb.append("\n");
                    else sb.append(" ");
                }
                // pq1과 pq2의 크기가 다르면(=pq2의 크기가 1 더 큼) 일단 pq1에 원소를 넣어야 함
                // pq2에서 제일 작은 애보다 n이 크면 pq2에서 제일 작은 애 pq1에 넣고 n을 pq2에 넣어줌
                // pq1에서 제일 작은 애보다 n이 작으면 그냥 pq1에 넣으면 됨
                else{
                    if(pq2.peek() > n){
                        pq1.offer(n);
                    }
                    else{
                        pq1.offer(pq2.poll());
                        pq2.offer(n);
                    }
                }
            }

            sb.append("\n");
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
