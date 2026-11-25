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

    while (true) {
        string s;
        cin >> s;

        if (s == ".") return 0;

        vector<int> pi = failure(s);
        int n = s.size();
        int p = n - pi.back();

        cout << (n % p == 0 ? n / p : 1) << '\n';
    }
}
