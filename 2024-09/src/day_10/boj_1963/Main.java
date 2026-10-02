package day_10.BOJ_G4_1963;

import java.io.*;
import java.util.*;

public class Main {

    // 0 ~ 9999 중 인덱스가 소수면 true
    // 테스트 케이스마다 초기화할 필요가 없어서 전역 변수로 선언
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 에라토스테네스의 체로 isPrime 배열 초기화
        init();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int primeA = Integer.parseInt(st.nextToken());
            int primeB = Integer.parseInt(st.nextToken());

            int ans = BFS(primeA, primeB);

            // ans는 소수 경로의 길이로 소수 경로를 못찾으면 -1 반환하고 두 수가 같아서 경로의 길이가 0일 수 있음
            if(ans >= 0){
                sb.append(ans).append("\n");
            }
            else{
                sb.append("Impossible\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 에라토스테네스의 체 알고리즘
    // 문제 조건에 4자리 소수만 유효해서 1000보다 작은 소수는 그냥 다시 false로 바꿔줌
    private static void init(){
        Arrays.fill(isPrime, true);

        for(int i=2 ; i*i<10000 ; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<10000 ; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0 ; i<1000 ; i++){
            isPrime[i] = false;
        }
    }

    // 소수 경로는 BFS를 통해 구할 수 있음
    // 동작 방식은 최단거리를 구하는 BFS와 유사
    // 다음 경로를 찾는 조건은 각 자리마다 0 ~ 9로 바꿔서 소수면 Queue에 넣음
    // 각 자리의 수를 바꾸는건 나눗셈과 모듈러 잡기술로 구현 가능
    private static int BFS(int primeA, int primeB){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(primeA);

        boolean[] visited = new boolean[10000];
        visited[primeA] = true;

        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                // Queue에서 꺼냈을 때 도착했는지를 판단해서 도착했으면 경로의 길이 반환
                if(node == primeB) return dist;

                // 0 ~ 9까지 넣어보는 반복문
                for(int j=0 ; j<10 ; j++){
                    // 천의 자리수를 바꿔서 소수면 큐에 넣음
                    int changeDigit1 = node % 1000 + j * 1000;
                    if(!visited[changeDigit1] && isPrime[changeDigit1]){
                        q.offer(changeDigit1);
                        visited[changeDigit1] = true;
                    }

                    // 백의 자리수를 바꿔서 소수면 큐에 넣음
                    int changeDigit2 = node / 1000 * 1000 + node % 100 + j * 100;
                    if(!visited[changeDigit2] && isPrime[changeDigit2]){
                        q.offer(changeDigit2);
                        visited[changeDigit2] = true;
                    }

                    // 십의 자리수를 바꿔서 소수면 큐에 넣음
                    int changeDigit3 = node / 100 * 100 + node % 10 + j * 10;
                    if(!visited[changeDigit3] && isPrime[changeDigit3]){
                        q.offer(changeDigit3);
                        visited[changeDigit3] = true;
                    }

                    // 일의 자리수를 바꿔서 소수면 큐에 넣음
                    int changeDigit4 = node / 10 * 10 + j;
                    if(!visited[changeDigit4] && isPrime[changeDigit4]){
                        q.offer(changeDigit4);
                        visited[changeDigit4] = true;
                    }
                }
            }

            dist++;
        }

        // 큐가 비었을 때까지 반환을 못했으면 소수 경로를 못찾은 것으로 음수를 반환해서 못찾은걸 알려줌
        return -1;
    }

}
