package day_18.BOJ_S3_9996;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), "*");
        String prefix = st.nextToken();
        String suffix = st.nextToken();

        for(int tc=1 ; tc<=T ; tc++){
            String str = br.readLine();

            if(prefix.length() + suffix.length() > str.length()){
                bw.write("NE\n");
                continue;
            }

            if(str.substring(0, prefix.length()).equals(prefix) && str.substring(str.length()-suffix.length(), str.length()).equals(suffix)){
                bw.write("DA\n");
            }
            else{
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}
