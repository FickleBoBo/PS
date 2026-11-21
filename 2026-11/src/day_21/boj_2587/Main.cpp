#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(5);
    for (int& x : v) cin >> x;

    int sum = 0;
    for (int x : v) sum += x;

    sort(v.begin(), v.end());

    cout << sum / 5 << '\n';
    cout << v[2] << '\n';
}
