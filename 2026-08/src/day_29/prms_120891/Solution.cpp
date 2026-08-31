#include <bits/stdc++.h>
using namespace std;

int solution(int order) {
    int cnt = 0;
    while (order > 0) {
        int d = order % 10;
        if (d == 3 || d == 6 || d == 9) cnt++;
        order /= 10;
    }

    return cnt;
}
