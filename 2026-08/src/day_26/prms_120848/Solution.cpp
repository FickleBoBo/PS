#include <bits/stdc++.h>
using namespace std;

int fact[1 + 10] = {1};

int solution(int n) {
    for (int i = 1; i <= 10; i++) {
        fact[i] = fact[i - 1] * i;
    }

    for (int i = 10; i >= 1; i--) {
        if (fact[i] <= n) return i;
    }

    return -1;
}
