#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int g = v[1] - v[0];
    for (int i = 2; i < n; i++) {
        g = gcd(g, v[i] - v[i - 1]);
    }

    cout << (v[n - 1] - v[0]) / g + 1 - n;
}
