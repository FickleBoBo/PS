#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    for (char c : s) {
        if ('a' <= c && c <= 'z') {
            cout << (char)(c - 'a' + 'A');
        } else {
            cout << (char)(c - 'A' + 'a');
        }
    }
}
