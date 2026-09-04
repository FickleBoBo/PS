#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int p = numer1 * denom2 + numer2 * denom1;
    int q = denom1 * denom2;
    int g = gcd(p, q);
    return {p / g, q / g};
}
