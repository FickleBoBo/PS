#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    stack<int> st;
    vector<bool> chk(1 + n);
    for (int i = 1; i <= n; i++) {
        int c = s[i - 1] - '0';
        if (c == 1) {
            st.push(i);
        } else if (c == 2) {
            if (!st.empty()) {
                st.pop();
                chk[i] = true;
            }
        }
    }

    while (!st.empty()) {
        chk[st.top()] = true;
        st.pop();
    }

    cout << count(chk.begin(), chk.end(), true) << '\n';
    for (int i = 1; i <= n; i++) {
        if (chk[i]) cout << i << ' ';
    }
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
