package day_11.BOJ_S5_7568;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 각 1차원 배열의 0번 인덱스에는 몸무게, 1번 인덱스에는 키, 2번 인덱스에는 등수 저장
        int[][] arr = new int[N][3];

        // 몸무게와 키 저장
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 등수 계산
        for(int i=0 ; i<N ; i++){
            int rank = 1;

            for(int j=0 ; j<N ; j++){
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    rank++;
                }
            }

            arr[i][2] = rank;
        }

        for(int i=0 ; i<N ; i++){
            sb.append(arr[i][2]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
