#include <bits/stdc++.h>
using namespace std;

const int MAX = 100000;
bool vis[1 + MAX];
int prv[1 + MAX];

void traceback(int dist, int k) {
    vector<int> v;

    int pos = k;
    while (pos != -1) {
        v.push_back(pos);
        pos = prv[pos];
    }

    reverse(v.begin(), v.end());

    cout << dist << '\n';

    for (int x : v) {
        cout << x << ' ';
    }
}

void bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    vis[n] = true;

    int dist = 0;

    memset(prv, -1, sizeof(prv));

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == k) {
                traceback(dist, k);
                return;
            }

            for (int nxt : {cur - 1, cur + 1, cur * 2}) {
                if (0 <= nxt && nxt <= MAX && !vis[nxt]) {
                    q.push(nxt);
                    vis[nxt] = true;
                    prv[nxt] = cur;
                }
            }
        }

        dist++;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    bfs(n, k);
}
