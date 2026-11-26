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

    int l;
    string s;
    cin >> l >> s;

    vector<int> pi = failure(s);
    int p = l - pi.back();

    cout << p;
}
