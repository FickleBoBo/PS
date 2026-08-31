package day_25.prms_120837;

class Solution {
    public int solution(int hp) {
        return hp / 5 + hp % 5 / 3 + hp % 5 % 3;
    }
}
