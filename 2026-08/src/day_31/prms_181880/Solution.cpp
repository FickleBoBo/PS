#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    int cnt = 0;
    for (int x : num_list) {
        while (x > 1) {
            x /= 2;
            cnt++;
        }
    }

    return cnt;
}
