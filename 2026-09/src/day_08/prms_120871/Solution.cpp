#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    int x = 0;
    int cnt = 0;
    while (cnt < n) {
        x++;
        if (x % 3 == 0 || to_string(x).find('3') != -1) continue;
        cnt++;
    }

    return x;
}
