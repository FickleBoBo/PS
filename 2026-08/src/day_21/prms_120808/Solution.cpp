#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int x = numer1 * denom2 + numer2 * denom1;
    int y = denom1 * denom2;
    int g = gcd(x, y);

    return {x / g, y / g};
}
