#include <bits/stdc++.h>
using namespace std;

int cnt[1000];

int solution(vector<int> array) {
    for (int x : array) cnt[x]++;

    int ans = -1;
    int mx = 0;
    bool uniq = false;

    for (int i = 0; i < 1000; i++) {
        if (cnt[i] > mx) {
            ans = i;
            mx = cnt[i];
            uniq = true;
        } else if (cnt[i] == mx) {
            uniq = false;
        }
    }

    return uniq ? ans : -1;
}
