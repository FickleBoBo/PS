package day_18.BOJ_S3_9627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] numberNames = new String[1+999];
        numberNames[0] = "";
        numberNames[1] = "one";
        numberNames[2] = "two";
        numberNames[3] = "three";
        numberNames[4] = "four";
        numberNames[5] = "five";
        numberNames[6] = "six";
        numberNames[7] = "seven";
        numberNames[8] = "eight";
        numberNames[9] = "nine";
        numberNames[10] = "ten";
        numberNames[11] = "eleven";
        numberNames[12] = "twelve";
        numberNames[13] = "thirteen";
        numberNames[14] = "fourteen";
        numberNames[15] = "fifteen";
        numberNames[16] = "sixteen";
        numberNames[17] = "seventeen";
        numberNames[18] = "eighteen";
        numberNames[19] = "nineteen";
        numberNames[20] = "twenty";
        numberNames[30] = "thirty";
        numberNames[40] = "forty";
        numberNames[50] = "fifty";
        numberNames[60] = "sixty";
        numberNames[70] = "seventy";
        numberNames[80] = "eighty";
        numberNames[90] = "ninety";
        numberNames[100] = "onehundred";
        numberNames[200] = "twohundred";
        numberNames[300] = "threehundred";
        numberNames[400] = "fourhundred";
        numberNames[500] = "fivehundred";
        numberNames[600] = "sixhundred";
        numberNames[700] = "sevenhundred";
        numberNames[800] = "eighthundred";
        numberNames[900] = "ninehundred";
        for(int i=21 ; i<100 ; i++){
            if(i % 10 != 0){
                numberNames[i] = numberNames[i/10 * 10] + numberNames[i % 10];
            }
        }
        for(int i=101 ; i<1000 ; i++){
            numberNames[i] = numberNames[i/100 * 100] + numberNames[i % 100];
        }

//        for(int i=1 ; i<1000 ; i++){
//            System.out.println(numberNames[i]);
//        }

        int[] number = new int[1+999];
        for(int i=1 ; i<1000 ; i++){
            number[i] = numberNames[i].length();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int len = -1;
        for(int i=0 ; i<N ; i++){
            String input = br.readLine();
            len += input.length();
            sb.append(input).append(" ");
        }

        for(int i=1 ; i<1000 ; i++){
            if(len + number[i] == i){
                String ans = sb.toString().replace("$", numberNames[i]);
                System.out.println(ans);
                break;
            }
        }
    }
}
