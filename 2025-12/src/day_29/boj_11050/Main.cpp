#include <bits/stdc++.h>
using namespace std;

int comb(int n, int r) {
    if (r == 0 || n == r) return 1;
    if (r == 1) return n;
    return comb(n - 1, r) + comb(n - 1, r - 1);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;
    cout << comb(n, k);
}
