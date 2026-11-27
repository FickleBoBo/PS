#include <bits/stdc++.h>
using namespace std;

vector<bool> sieve(int n) {
    vector<bool> isPrime(1 + n, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
}

int solution(int n) {
    vector<bool> isPrime = sieve(n);
    int cnt = 0;

    for (int i = 2; i <= n; i++) {
        if (!isPrime[i]) cnt++;
    }

    return cnt;
}
