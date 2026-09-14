#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> cnt(2);
    while (n--) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    if (cnt[1] >= cnt[0]) {
        cout << "Bessie\n";
    } else {
        cout << "Elsie\n";
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
