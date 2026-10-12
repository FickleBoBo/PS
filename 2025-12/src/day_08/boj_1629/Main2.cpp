#include <bits/stdc++.h>
using namespace std;

long long mod_pow(long long a, long long b, long long c) {
    if (b == 0) return 1;

    long long half = mod_pow(a, b / 2, c);
    if (b % 2) {
        return half * half % c * a % c;
    } else {
        return half * half % c;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    cout << mod_pow(a, b, c);
}
