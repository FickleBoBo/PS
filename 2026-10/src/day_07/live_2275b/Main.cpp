#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    vector<int> v;
    vector<int> v2;
    for (int i = 1; i <= n; i++) {
        int c = s[i - 1] - '0';
        if (c == 1) {
            v.push_back(i);
        } else if (c == 2) {
            if (!v.empty()) {
                v.pop_back();
                v2.push_back(i);
            }
        }
    }
    for (int x : v2) v.push_back(x);
    sort(v.begin(), v.end());

    cout << v.size() << '\n';
    for (int x : v) cout << x << ' ';
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
