#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    stringstream ss(s);
    string token;
    int mx = 0;
    while (getline(ss, token, '*')) {
        mx = max(mx, ((int)token.size() + 1) / 2);
    }

    cout << mx << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
