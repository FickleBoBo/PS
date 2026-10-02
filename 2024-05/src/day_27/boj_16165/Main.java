package day_27.BOJ_S3_16165;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, String> map = new HashMap<>();

        for(int i=0 ; i<N ; i++){
            String value = sc.next();
            int num = sc.nextInt();
            for(int j=0 ; j<num ; j++){
                map.put(sc.next(), value);
            }
        }

        for(int i=0 ; i<M ; i++){
            String input1 = sc.next();
            int input2 = sc.nextInt();
            if(input2 == 1){
                System.out.println(map.get(input1));
            }
            else{
                List<String> list = new ArrayList<>();
                for(String key : map.keySet()){
                    if(map.get(key).equals(input1)){
                        list.add(key);
                    }
                }
                Collections.sort(list);

                for(String ans : list){
                    System.out.println(ans);
                }
            }
        }
    }
}
