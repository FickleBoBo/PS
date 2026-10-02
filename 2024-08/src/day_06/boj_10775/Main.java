package day_06.BOJ_G2_10775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        // 인덱스에 비행기 번호, 값에 해당 비행기가 도킹할 게이트 번호 저장
        int[] check = new int[1+G];
        for(int i=1 ; i<=G ; i++) check[i] = i;

        // 도킹했는지 방문 체크(n번 비행기가 여러번 들어오고 n-1번 비행기가 들어오면 n-1번 비행기가 n-1번 게이트에 도킹하는거 방지)
        boolean[] visited = new boolean[1+G];

        int ans = 0;

        out:
        for(int i=0 ; i<P ; i++){
            int g = Integer.parseInt(br.readLine());

            // 같은 비행기가 또 주어지면 최근 도킹한 위치부터 거슬러 찾음(원래 O(N²) 풀이는 안되는데 최적화 조금해서 됨)
            for(int j=check[g] ; j>0 ; j--){
                if(visited[j]) continue;

                // 도킹하고 방문체크하고 도킹 횟수 갱신
                check[g] = j;
                visited[j] = true;
                ans++;

                continue out;
            }

            // 끝까지 도킹 못하면 종료
            break;
        }

        System.out.println(ans);
    }
}
