#include <bits/stdc++.h>
using namespace std;

long long solution(int a, int b) {
    return 1LL * (a + b) * (abs(b - a) + 1) / 2;
}
