#include <bits/stdc++.h>
using namespace std;

const int MAX = 500000;
bool vis[1 + MAX][2];

int bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    vis[n][0] = true;

    int time = 0;

    while (!q.empty()) {
        int bro = k + time * (time + 1) / 2;
        if (bro > MAX) return -1;

        if (vis[bro][time % 2]) return time;

        int next_parity = (time + 1) % 2;
        int sz = q.size();
        while (sz--) {
            int cur = q.front();
            q.pop();

            for (int nxt : {cur - 1, cur + 1, cur * 2}) {
                if (0 <= nxt && nxt <= MAX && !vis[nxt][next_parity]) {
                    q.push(nxt);
                    vis[nxt][next_parity] = true;
                }
            }
        }

        time++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;
    cout << bfs(n, k);
}
