#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    iota(v.begin(), v.end(), 1);

    while (m--) {
        int s, e;
        cin >> s >> e;
        swap(v[s - 1], v[e - 1]);
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
