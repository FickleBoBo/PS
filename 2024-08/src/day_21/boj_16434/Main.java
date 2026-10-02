package day_21.BOJ_G4_16434;

import java.io.*;
import java.util.*;

// 타입 캐스팅 예외가 많이 나서 long이 섞이면 그냥 long으로 대충 통일하는게 맘편함
public class Main {

    // 방 클래스
    static class Room{
        int type;    // 몬스터 방은 1, 포션 방은 2 (enum으로 해보려했는데 문법을 몰라서 포기)
        long atk;    // 몬스터 방이면 몬스터의 공격력, 포션 방이면 포션의 공격력 증가
        long hp;    // 몬스터 방이면 몬스터의 체력, 포션 방이면 포션의 체력 증가

        public Room(int type, long atk, long hp) {
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }

    // 용사 클래스
    static class Hero{
        long heroMaxHP;    // 용사의 최대 체력
        long heroCurHP;    // 용사의 현재 체력
        long heroAtk;    // 용사의 공격력

        // 생성자는 최대 체력과 공격력만 받고 현재 체력도 최대 체력으로 초기화
        public Hero(long heroMaxHP, long heroAtk) {
            this.heroMaxHP = heroMaxHP;
            this.heroCurHP = heroMaxHP;
            this.heroAtk = heroAtk;
        }

        // 몬스터와 싸워서 용사가 사망하면 false, 몬스터가 사망하면 true
        // 싸우는 원리는 서로의 공격력과 현재 체력을 기반으로 공격 횟수를 계산
        // 용사가 선빵이니까 용사의 공격 횟수가 몬스터의 공격 횟수보다 많으면 게 진다(false)
        // 반복문으로 한번씩 공방을 주고 받으면 시간초과
        public boolean fight(long monsHP, long monsAtk){
            long heroAtkCnt = monsHP / heroAtk;
            if(monsHP % heroAtk > 0) heroAtkCnt += 1;

            long monsAtkCnt = heroCurHP / monsAtk;
            if(heroCurHP % monsAtk > 0) monsAtkCnt += 1;

            if(heroAtkCnt > monsAtkCnt){
                return false;
            }
            else{
                heroCurHP -= monsAtk * (heroAtkCnt - 1);
                return true;
            }
        }

        // 포션 먹기
        public void drinkPotion(long potionHP, long potionAtk){
            heroCurHP = Math.min(heroCurHP + potionHP, heroMaxHP);
            heroAtk += potionAtk;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long heroAtk = Integer.parseInt(st.nextToken());
        Room[] input = new Room[N];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            long atk = Integer.parseInt(st.nextToken());
            long hp = Integer.parseInt(st.nextToken());

            input[i] = new Room(type, atk, hp);
        }

        long ans = binarySearchLowerBound(heroAtk, N, input);

        System.out.println(ans);
    }

    // 매개변수 이분탐색으로 용사가 드래곤을 쓰러트리기 위한 체력을 찾음
    private static long binarySearchLowerBound(long heroAtk, int N, Room[] input){
        long left = 1;
        long right = Long.MAX_VALUE - 1;

        while(left < right){
            long heroMaxHP = left / 2 + right / 2;

            // 매개변수 이분탐색으로 용사의 체력을 세팅
            boolean flag = true;
            Hero hero = new Hero(heroMaxHP, heroAtk);

            // 해당 체력으로 던전을 돌아서 사망했는지 살아있는지 flag에 저장
            for(int i=0 ; i<N ; i++){
                if(input[i].type == 1){
                    if(!hero.fight(input[i].hp, input[i].atk)){
                        flag = false;
                        break;
                    }
                }
                else{
                    hero.drinkPotion(input[i].hp, input[i].atk);
                }
            }

            // 용사가 사망했으면 체력을 높여서 탐색하고 용사가 살아있으면 체력을 낮춰서 탐색
            if(!flag){
                left = heroMaxHP + 1;
            }
            else{
                right = heroMaxHP;
            }
        }

        return right;
    }

}
