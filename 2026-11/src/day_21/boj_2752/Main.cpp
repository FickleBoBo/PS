#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(3);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    for (int x : v) {
        cout << x << ' ';
    }
}
