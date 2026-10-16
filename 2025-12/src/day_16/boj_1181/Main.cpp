#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<string> v(n);
    for (string& x : v) cin >> x;
    sort(v.begin(), v.end(), [](auto& a, auto& b) {
        if (a.size() != b.size()) return a.size() < b.size();
        return a < b;
    });

    string prv;
    for (string& s : v) {
        if (s == prv) continue;

        cout << s << '\n';
        prv = s;
    }
}
