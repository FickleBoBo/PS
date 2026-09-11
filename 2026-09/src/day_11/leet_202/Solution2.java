package day_11.leet_202;

class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = step(n);
        while (slow != fast) {
            slow = step(slow);
            fast = step(step(fast));
        }

        return slow == 1;
    }

    static int step(int x) {
        int sum = 0;
        while (x > 0) {
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }

        return sum;
    }
}
