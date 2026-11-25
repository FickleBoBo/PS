#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sum = 0;
    for (int i = 0; i < 5; i++) {
        int x;
        cin >> x;
        sum += max(x, 40);
    }

    cout << sum / 5;
}
