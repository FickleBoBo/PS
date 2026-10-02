package day_14.BOJ_S5_9626;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] map = new char[U + M + D][L + N + R];

        for(int i=U ; i< U + M ; i++){
            String input = br.readLine();

            for(int j=L ; j< L + N ; j++){
                map[i][j] = input.charAt(j - L);
            }
        }

        for(int i=0 ; i<map.length ; i++){
            for(int j=0 ; j<map[i].length ; j++){
                if(map[i][j] == '\u0000'){
                    if((i + j) % 2 == 0){
                        sb.append('#');
                    }
                    else{
                        sb.append('.');
                    }
                }
                else{
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
