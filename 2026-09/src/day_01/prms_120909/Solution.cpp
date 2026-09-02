#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    int r = round(sqrt(n));
    return r * r == n ? 1 : 2;
}
