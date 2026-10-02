package day_20.PGMS_LV3_보석_쇼핑;

import java.util.*;

class Solution_Fail2 {
    public int[] solution(String[] gems) {
        Set<String> total = new HashSet<>();
        for(String gem : gems) total.add(gem);

        int N = total.size();
        int[] ans = new int[]{1, gems.length};

        for(int i=0 ; i<gems.length ; i++){
            Set<String> set = new HashSet<>();

            for(int j=i ; j<gems.length ; j++){
                set.add(gems[j]);

                if(set.size() == N){
                    if(j-i < ans[1] - ans[0]){
                        ans[0] = i + 1;
                        ans[1] = j + 1;
                    }
                    else if((j-i == ans[1] - ans[0]) && i < ans[0]){
                        ans[0] = i + 1;
                        ans[1] = j + 1;
                    }
                    break;
                }
            }
        }

        return ans;
    }
}

//테스트 1 〉	통과 (0.12ms, 73.4MB)
//테스트 2 〉	통과 (0.29ms, 76.9MB)
//테스트 3 〉	통과 (1.21ms, 79.6MB)
//테스트 4 〉	통과 (13.44ms, 84.7MB)
//테스트 5 〉	통과 (0.21ms, 77.9MB)
//테스트 6 〉	통과 (0.06ms, 67.6MB)
//테스트 7 〉	통과 (0.09ms, 73MB)
//테스트 8 〉	통과 (17.98ms, 86.1MB)
//테스트 9 〉	통과 (11.90ms, 82.5MB)
//테스트 10 〉통과 (31.97ms, 87.3MB)
//테스트 11 〉통과 (56.69ms, 93.5MB)
//테스트 12 〉통과 (14.93ms, 83.8MB)
//테스트 13 〉통과 (22.25ms, 83.9MB)
//테스트 14 〉통과 (167.99ms, 119MB)
//테스트 15 〉통과 (35.99ms, 88.1MB)

//테스트 1 〉	통과 (126.28ms, 70.2MB)
//테스트 2 〉	실패 (시간 초과)
//테스트 3 〉	통과 (210.62ms, 84.7MB)
//테스트 4 〉	실패 (시간 초과)
//테스트 5 〉	실패 (시간 초과)
//테스트 6 〉	통과 (195.14ms, 87.9MB)
//테스트 7 〉	실패 (시간 초과)
//테스트 8 〉	실패 (시간 초과)
//테스트 9 〉	통과 (625.62ms, 220MB)
//테스트 10 〉실패 (시간 초과)
//테스트 11 〉실패 (시간 초과)
//테스트 12 〉실패 (시간 초과)
//테스트 13 〉실패 (시간 초과)
//테스트 14 〉실패 (시간 초과)
//테스트 15 〉실패 (시간 초과)
