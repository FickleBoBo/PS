#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c, d;
    cin >> a >> b >> c >> d;

    int p = a * d + b * c;
    int q = b * d;
    int g = gcd(p, q);

    cout << p / g << ' ' << q / g;
}
