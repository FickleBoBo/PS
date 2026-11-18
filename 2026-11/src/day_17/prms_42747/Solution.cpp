#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());

    int n = citations.size();
    for (int i = 0; i < n; i++) {
        int h = n - i;
        if (citations[i] >= h) return h;
    }

    return 0;
}
