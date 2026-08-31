#include <bits/stdc++.h>
using namespace std;

int solution(string begin, string target, vector<string> words) {
    unordered_set<string> dict(words.begin(), words.end());

    queue<string> q;
    q.push(begin);

    unordered_set<string> vis;
    vis.insert(begin);

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();
        while (sz--) {
            string cur = q.front();
            q.pop();

            if (cur == target) return dist;

            for (int i = 0; i < cur.size(); i++) {
                string nxt = cur;
                for (char c = 'a'; c <= 'z'; c++) {
                    nxt[i] = c;
                    if (!dict.contains(nxt) || vis.contains(nxt)) continue;

                    q.push(nxt);
                    vis.insert(nxt);
                }
            }
        }

        dist++;
    }

    return 0;
}
