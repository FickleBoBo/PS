#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(8);
    for (int& x : v) cin >> x;

    bool is_asc = true;
    bool is_desc = true;

    for (int i = 1; i < 8; i++) {
        if (v[i] < v[i - 1]) is_asc = false;
        if (v[i] > v[i - 1]) is_desc = false;
    }

    if (is_asc) {
        cout << "ascending";
    } else if (is_desc) {
        cout << "descending";
    } else {
        cout << "mixed";
    }
}
