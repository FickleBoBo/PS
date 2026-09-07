#include <bits/stdc++.h>
using namespace std;

int solution(int a, int b) {
    int q = b / gcd(a, b);
    while (q % 2 == 0) q /= 2;
    while (q % 5 == 0) q /= 5;

    return q == 1 ? 1 : 2;
}
