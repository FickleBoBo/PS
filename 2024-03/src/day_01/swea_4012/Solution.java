package day_01.SWEA_모의SW역량테스트_4012;

import java.util.Scanner;

public class Solution {

    static int ans;    // 조합마다 갱신할거라 그냥 static 변수로 선언

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){    // 각각의 테스트 케이스

            // step1 - 입력 받기
            int N = sc.nextInt();
            int[][] table = new int[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    table[i][j] = sc.nextInt();
                }
            }
            ans = Integer.MAX_VALUE;    // 최솟값을 찾을 것이므로 정수형 최댓값을 할당

            int[] arr1 = new int[N/2];    // 재료를 2가지로 쪼개서 넣을거라 절반 크기 배열 선언
            int[] arr2 = new int[N/2];    // 222
            int arr1idx = 0;              // 넣을 때 사용할 인덱스
            int arr2idx = 0;              // 222

            // step2 - 가능한 조합을 쪼갠 배열에 넣어준다(조합 못해서 억지로 이렇게 함)
            for(int i=0 ; i < (1<<N) ; i++){
                String tmp = Integer.toBinaryString(i);    // 개꿀 메서드 발견
                while(tmp.length() < N){
                    tmp = "0" + tmp;    // N 자리 배열로 만들어주려고 앞에 0 넣어서 양식 맞춤
                }
                String[] input = tmp.split("");
                int cnt = 0;
                for(int j=0 ; j<input.length ; j++){
                    if(input[j].equals("1")){
                        cnt++;
                    }
                }
                if(cnt == N/2){    // 절반이 선택되었을 때
                    for(int k=0 ; k<input.length ; k++){    // 두 배열에 넣어줌
                        if(input[k].equals("1")){
                            arr1[arr1idx++] = k;
                        }
                        else{
                            arr2[arr2idx++] = k;
                        }
                    }
                    synergyDiff(arr1, arr2, table);    // 계산 돌리기
                    arr1idx = 0;
                    arr2idx = 0;
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }

    // 재료로 만든 요리의 시너지 합의 차이를 계산하는 메서드
    static void synergyDiff(int[] ingredient1, int[] ingredient2, int[][] pointTable){
        int len = pointTable.length/2;
        int sum1 = 0;
        int sum2 = 0;

        // A요리의 합 계산
        for(int i=0 ; i<len-1 ; i++){
            for(int j=i+1 ; j<len ; j++){
                sum1 += pointTable[ingredient1[i]][ingredient1[j]];
                sum1 += pointTable[ingredient1[j]][ingredient1[i]];
            }
        }

        // B요리의 합 계산
        for(int i=0 ; i<len-1 ; i++){
            for(int j=i+1 ; j<len ; j++){
                sum2 += pointTable[ingredient2[i]][ingredient2[j]];
                sum2 += pointTable[ingredient2[j]][ingredient2[i]];
            }
        }

        ans = Math.min(ans, Math.abs(sum1 - sum2));

    }

}
