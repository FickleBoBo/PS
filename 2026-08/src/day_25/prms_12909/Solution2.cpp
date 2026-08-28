#include <bits/stdc++.h>
using namespace std;

bool solution(string s) {
    int cnt = 0;
    for (char c : s) {
        if (c == '(') {
            cnt++;
        } else {
            if (cnt == 0) return false;
            cnt--;
        }
    }

    return cnt == 0;
}
