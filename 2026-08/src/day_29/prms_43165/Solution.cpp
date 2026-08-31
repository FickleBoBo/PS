#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers, int target) {
    queue<int> q;
    q.push(0);

    for (int x : numbers) {
        int sz = q.size();
        while (sz--) {
            int cur = q.front();
            q.pop();

            q.push(cur + x);
            q.push(cur - x);
        }
    }

    int cnt = 0;
    while (!q.empty()) {
        if (q.front() == target) cnt++;
        q.pop();
    }

    return cnt;
}
