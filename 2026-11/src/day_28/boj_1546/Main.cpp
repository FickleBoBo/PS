#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    int mx = *max_element(v.begin(), v.end());

    double sum = 0;
    for (int x : v) {
        sum += (double)x / mx * 100;
    }

    cout << sum / n;
}
