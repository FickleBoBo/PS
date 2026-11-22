#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int x;
    cin >> x;

    int l = 0, r = n - 1;
    int cnt = 0;
    while (l < r) {
        if (v[l] + v[r] < x) {
            l++;
        } else if (v[l] + v[r] > x) {
            r--;
        } else {
            cnt++;
            l++;
            r--;
        }
    }

    cout << cnt;
}
