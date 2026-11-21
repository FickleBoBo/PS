#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long a, b;
    cin >> a >> b;

    if (a > b) swap(a, b);

    cout << max(b - a - 1, 0LL) << '\n';
    for (long long i = a + 1; i < b; i++) {
        cout << i << ' ';
    }
}
