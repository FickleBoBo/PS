#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> array) {
    int cnt = 0;
    for (int x : array) {
        while (x > 0) {
            if (x % 10 == 7) cnt++;
            x /= 10;
        }
    }

    return cnt;
}
