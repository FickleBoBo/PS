package day_09.BOJ_B1_1157;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // alphabet : 알파벳 대문자 순서대로 26개 넣은 배열
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        // countingArr : 알파벳과 순서를 맞춘 카운팅 배열
        int[] countingArr = new int[26];

        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();    // 입력을 char[]로 변환해서 받음

        // 카운팅 배열 채우기로 char[]에서 char을 하나씩 뽑아서 소문자로 바꾸고 a를 빼주고 int로 형변환하면 카운팅 배열에 넣기 좋음
        for(char c : input) {
            countingArr[(int) (Character.toLowerCase(c) - 'a')]++;
        }

        // 최댓값과 인덱스 찾기
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=0 ; i<countingArr.length ; i++){
            if(countingArr[i] > max){
                max = countingArr[i];
                maxIdx = i;
            }
        }

        // 최댓값이 복수인지 찾아야하는데 sort를 쓰면 원본이 바뀌어서 인덱스 구한게 의미가 없어짐
        int[] tmp = Arrays.copyOf(countingArr, countingArr.length);
        Arrays.sort(tmp);

        if(tmp[25] == tmp[24]){
            System.out.println("?");
        }
        else{
            System.out.println(alphabet[maxIdx]);
        }

        sc.close();
    }
}
