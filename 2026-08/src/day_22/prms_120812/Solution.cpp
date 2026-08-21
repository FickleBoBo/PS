#include <bits/stdc++.h>
using namespace std;

int cnt[1000];

int solution(vector<int> array) {
    for (int x : array) cnt[x]++;

    int ans = -1;
    int mx = 0;
    bool flag = false;

    for (int i = 0; i < 1000; i++) {
        if (cnt[i] > mx) {
            ans = i;
            mx = cnt[i];
            flag = true;
        } else if (cnt[i] == mx) {
            flag = false;
        }
    }

    if (flag) return ans;
    return -1;
}
