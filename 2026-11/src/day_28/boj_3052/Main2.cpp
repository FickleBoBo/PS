#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_set<int> seen;
    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        seen.insert(x % 42);
    }

    cout << seen.size();
}
