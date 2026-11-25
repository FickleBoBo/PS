#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int r;
        string s;
        cin >> r >> s;

        for (char c : s) {
            cout << string(r, c);
        }
        cout << '\n';
    }
}
