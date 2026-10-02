package day_18.BOJ_S4_1244;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int swithNum = sc.nextInt();
        boolean[] swith = new boolean[swithNum+1];
        for(int i=1 ; i<=swithNum ; i++){
            if(sc.nextInt()==1){
                swith[i] = true;
            }
        }

        int num = sc.nextInt();
        for(int i=0 ; i<num ; i++){
            int gender = sc.nextInt();
            int pos = sc.nextInt();
            if(gender==1){
                for(int j=pos ; j<=swithNum ; j++){
                    if(j % pos == 0){
                        swith[j] = !swith[j];
                    }
                }
            }
            else{
                swith[pos] = !swith[pos];
                int len = Math.min(pos-1, swithNum-pos);
                for(int k=1 ; k<=len ; k++){
                    if(swith[pos-k] == swith[pos+k]){
                        swith[pos-k] = !swith[pos-k];
                        swith[pos+k] = !swith[pos+k];
                    }
                    else{
                        break;
                    }
                }
            }

        }

        int[] printSwith = new int[swithNum+1];
        for(int i=1 ; i<=swithNum ; i++){
            if(swith[i]){
                printSwith[i] = 1;
            }
        }

        for(int i=1 ; i<=swithNum ; i++){
            System.out.printf("%d ", printSwith[i]);
            if(i % 20 == 0){
                System.out.println();
            }
        }
        sc.close();
    }
}
