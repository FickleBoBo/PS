#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        string s1, s2;
        cin >> s1 >> s2;

        vector<int> cnt(26);
        for (char c : s1) cnt[c - 'a']++;
        for (char c : s2) cnt[c - 'a']--;

        bool flag = true;
        for (int x : cnt) {
            if (x != 0) {
                flag = false;
                break;
            }
        }

        cout << (flag ? "Possible\n" : "Impossible\n");
    }
}
