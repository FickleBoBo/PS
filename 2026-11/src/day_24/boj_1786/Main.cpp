#include <bits/stdc++.h>
using namespace std;

vector<int> failure(string& s) {
    vector<int> pi(s.size());
    int j = 0;
    for (int i = 1; i < s.size(); i++) {
        while (j > 0 && s[i] != s[j]) j = pi[j - 1];
        if (s[i] == s[j]) pi[i] = ++j;
    }
    return pi;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string t, p;
    getline(cin, t);
    getline(cin, p);

    vector<int> pi = failure(p);
    vector<int> res;
    int j = 0;
    for (int i = 0; i < t.size(); i++) {
        while (j > 0 && t[i] != p[j]) j = pi[j - 1];
        if (t[i] == p[j]) j++;
        if (j == p.size()) {
            res.push_back(i - j + 1);
            j = pi[j - 1];
        }
    }

    cout << res.size() << '\n';
    for (int x : res) {
        cout << x + 1 << ' ';
    }
}
