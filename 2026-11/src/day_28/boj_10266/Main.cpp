#include <bits/stdc++.h>
using namespace std;

vector<int> failure(vector<bool>& s) {
    vector<int> pi(s.size());
    int j = 0;
    for (int i = 1; i < s.size(); i++) {
        while (j > 0 && s[i] != s[j]) j = pi[j - 1];
        if (s[i] == s[j]) pi[i] = ++j;
    }
    return pi;
}

bool kmp(vector<bool>& s, vector<bool>& p) {
    vector<int> pi = failure(p);
    int j = 0;
    for (int i = 0; i < s.size(); i++) {
        while (j > 0 && s[i] != p[j]) j = pi[j - 1];
        if (s[i] == p[j]) j++;
        if (j == p.size()) return true;
    }

    return false;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<bool> s(360000);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        s[x] = true;
    }
    vector<bool> tmp = s;
    s.insert(s.end(), tmp.begin(), tmp.end());
    s.pop_back();

    vector<bool> p(360000);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        p[x] = true;
    }

    cout << (kmp(s, p) ? "possible" : "impossible");
}
