#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    cout << (a + (b + c) / 60) % 24 << ' ' << (b + c) % 60;
}
