package day_30.BOJ_S3_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine()+" ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int[] nums = new int[N];
        int[] numsCnt = new int[4000+1+4000];
        int sum = 0;
        int idx = 0;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            nums[idx++] = n;
            numsCnt[n+4000]++;
            sum += n;
        }
        Arrays.sort(nums);

        int a = (int) Math.round((double) sum / N);

        int b = nums[N/2];


        int c = 0;
        int maxInx = -1;
        for(int i=0 ; i<numsCnt.length ; i++){
            maxInx = Math.max(maxInx, numsCnt[i]);
        }

        int cnt = 0;
        for(int i=0 ; i<numsCnt.length ; i++){
            if(maxInx == numsCnt[i]) cnt++;
        }

        if(cnt == 1){
            for(int i=0 ; i<numsCnt.length ; i++){
                if(maxInx == numsCnt[i]) {
                    c = i-4000;
                    break;
                }
            }
        }
        else{
            int n = 0;
            for(int i=0 ; i<numsCnt.length ; i++){
                if(maxInx == numsCnt[i]) {
                    c = i-4000;
                    n++;
                }
                if(n==2){
                    c = i-4000;
                    break;
                }
            }
        }

        int d = nums[N-1] - nums[0];

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        br.close();
    }
}
