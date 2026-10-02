package day_28.BOJ_S2_16953;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = BFS(A, B);

        System.out.println(ans);
    }

    // B에서 A를 찾아나감
    private static int BFS(int A, int B){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(B);

        int ans = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                if(node < A) continue;    // A보다 작은건 버려야 함
                else if(node == A) return ans;    // 종료 조건

                // 2의 배수면 2로 나눈다
                if(node % 2 == 0){
                    q.offer(node / 2);
                }
                // 끝자리가 1이면 1을 빼고 10으로 나눈다
                else if(((node - 1) % 10) == 0){
                    q.offer((node - 1) / 10);
                }
            }

            ans++;
        }

        return -1;    // 못 찾은 경우
    }

}
