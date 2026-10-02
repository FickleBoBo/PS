package day_04.BOJ_S3_1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.next();
        }

        List<Character> nums = new ArrayList<>();
        for(int i=1 ; i<10 ; i++){
            nums.add((char) (i+'0'));
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            }
            else{
                int num1 = 0;
                int num2 = 0;
                for(int i=0 ; i<o1.length() ; i++){
                    if(nums.contains(o1.charAt(i))){
                        num1 += Character.getNumericValue(o1.charAt(i));
                    }
                    if(nums.contains(o2.charAt(i))){
                        num2 += Character.getNumericValue(o2.charAt(i));
                    }
                }
                if(num1 != num2){
                    return num1 - num2;
                }
                else{
                    for(int i=0 ; i<o1.length() ; i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return 0;
                }
            }
        }));

        for(String str : arr){
            System.out.println(str);
        }

        sc.close();
    }
}
