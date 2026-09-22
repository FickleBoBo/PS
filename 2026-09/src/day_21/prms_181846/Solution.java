package day_21.prms_181846;

import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger x = new BigInteger(a);
        BigInteger y = new BigInteger(b);
        return x.add(y).toString();
    }
}
