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

int kmp(string& s, string& p) {
    vector<int> pi = failure(p);
    int cnt = 0;
    int j = 0;
    for (int i = 0; i < s.size(); i++) {
        while (j > 0 && s[i] != p[j]) j = pi[j - 1];
        if (s[i] == p[j]) j++;
        if (j == p.size()) {
            cnt++;
            j = pi[j - 1];
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    string p;
    for (int i = 0; i < n; i++) {
        char c;
        cin >> c;
        p += c;
    }

    string s;
    for (int i = 0; i < n; i++) {
        char c;
        cin >> c;
        s += c;
    }
    s += s;
    s.pop_back();

    int cnt = kmp(s, p);
    int g = gcd(cnt, n);
    cout << cnt / g << '/' << n / g;
}
