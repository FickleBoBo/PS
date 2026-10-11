#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<bool> seen(42);
    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        seen[x % 42] = true;
    }

    cout << count(seen.begin(), seen.end(), true);
}
