#include <bits/stdc++.h>
using namespace std;

long long mod_pow(long long a, long long b, long long c) {
    long long res = 1;
    while (b > 0) {
        if (b & 1) res = res * a % c;
        a = a * a % c;
        b >>= 1;
    }

    return res;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    cout << mod_pow(a, b, c);
}
