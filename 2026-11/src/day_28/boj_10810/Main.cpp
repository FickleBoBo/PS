#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    while (m--) {
        int s, e, x;
        cin >> s >> e >> x;
        fill(v.begin() + s - 1, v.begin() + e, x);
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
