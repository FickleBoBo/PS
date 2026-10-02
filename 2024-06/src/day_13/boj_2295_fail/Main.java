package day_13.BOJ_G4_2295_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Long> map = new HashMap<>();
        for(int i=0 ; i<N ; i++){
            map.put(i, Long.parseLong(br.readLine()));
        }

        long ans = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=i ; j<N ; j++){
                for(int k=j ; k<N ; k++){
                    long tmp = map.get(i) + map.get(j) + map.get(k);
                    if(map.containsValue(tmp)){
                        ans = Math.max(ans, tmp);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
