#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> array, int height) {
    int cnt = 0;
    for (int x : array) {
        if (x > height) cnt++;
    }

    return cnt;
}
