#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(20);
    iota(v.begin(), v.end(), 1);

    for (int i = 0; i < 10; i++) {
        int s, e;
        cin >> s >> e;
        reverse(v.begin() + s - 1, v.begin() + e);
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
