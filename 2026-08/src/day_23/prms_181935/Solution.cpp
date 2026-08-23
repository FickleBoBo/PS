#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    if (n % 2) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    } else {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i * i;
        }
        return sum;
    }
}
