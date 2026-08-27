#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    if (n % 2) {
        int k = (n + 1) / 2;
        return k * k;
    } else {
        int k = n / 2;
        return 2 * k * (k + 1) * (2 * k + 1) / 3;
    }
}
