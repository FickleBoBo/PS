#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    unordered_set<string> st1;
    while (n--) {
        string s;
        cin >> s;
        st1.insert(s);
    }

    unordered_set<string> st2;
    while (m--) {
        string s;
        cin >> s;
        st2.insert(s);
    }

    set<string> inter;
    if (st1.size() > st2.size()) swap(st1, st2);

    for (auto& s : st1) {
        if (st2.count(s)) inter.insert(s);
    }

    cout << inter.size() << '\n';
    for (auto& s : inter) {
        cout << s << '\n';
    }
}
