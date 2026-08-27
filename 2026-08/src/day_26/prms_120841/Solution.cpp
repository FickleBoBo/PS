#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> dot) {
    int x = dot[0], y = dot[1];

    if (x > 0) {
        if (y > 0) {
            return 1;
        } else {
            return 4;
        }
    } else {
        if (y > 0) {
            return 2;
        } else {
            return 3;
        }
    }
}
