#include <bits/stdc++.h>
using namespace std;

int cnt[10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    for (char c : s) {
        cnt[c - '0']++;
    }

    int mx = 0;
    for (int i = 0; i < 10; i++) {
        if (i == 6 || i == 9) continue;
        mx = max(mx, cnt[i]);
    }
    mx = max(mx, (cnt[6] + cnt[9] + 1) / 2);

    cout << mx;
}
