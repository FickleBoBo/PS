#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, s;
    cin >> n >> s;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int g = 0;
    for (int x : v) {
        g = gcd(g, abs(s - x));
    }

    cout << g;
}
