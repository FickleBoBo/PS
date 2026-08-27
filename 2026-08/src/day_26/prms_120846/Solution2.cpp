#include <bits/stdc++.h>
using namespace std;

vector<bool> sieve(int n) {
    vector<bool> is_prime(1 + n, true);
    is_prime[0] = is_prime[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (is_prime[i]) {
            for (int j = i * i; j <= n; j += i) {
                is_prime[j] = false;
            }
        }
    }

    return is_prime;
}

int solution(int n) {
    vector<bool> is_prime = sieve(n);
    int cnt = 0;

    for (int i = 2; i <= n; i++) {
        if (!is_prime[i]) cnt++;
    }

    return cnt;
}
