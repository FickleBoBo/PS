package day_11.BOJ_S5_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[] countingArr = new boolean[2_000_001];

        for(int i=1 ; i<=N ; i++){
            countingArr[Integer.parseInt(br.readLine())+1_000_000] = true;
        }

        // 중복이 없으므로 boolean 카운팅으로 계산(sort는 시간 초과나는듯)
        for(int i=0 ; i<=2_000_000 ; i++){
            if(countingArr[i]){
                sb.append((i-1_000_000)+"\n");
            }
        }

        // print는 느려서 스트링빌더로 해야하는듯?
        System.out.print(sb);

        br.close();
    }
}
