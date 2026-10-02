package day_06.BOJ_G4_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            sb.append(br.readLine());
        }
        String[] data = sb.toString().split("");

        int[][] map = new int[1+n][1+m];

        int ans = 0;
        int idx = 0;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                map[i][j] = Integer.parseInt(data[idx++]);
                if(map[i][j]==1){
                    ans = Math.max(ans, 1);
                    if(map[i-1][j-1]>0){
                        boolean flag = true;
                        for(int k=1 ; k<=map[i-1][j-1] ; k++){
                            if(map[i-k][j]==0 || map[i][j-k]==0){
                                flag = false;
                                break;
                            }
                            else{
                                map[i][j]++;
                            }
                        }
                        if(flag){
                            map[i][j] = map[i-1][j-1] + 1;
                            ans = Math.max(ans, map[i][j]);
                        }
                    }
                }
            }
        }

//        for(int i=1 ; i<=n ; i++){
//            for(int j=1 ; j<=m ; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans * ans);

    }
}
