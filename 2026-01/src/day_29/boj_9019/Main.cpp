#include <bits/stdc++.h>
using namespace std;

bool vis[10000];
int prv[10000];
char type[10000];
string ans;

void bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    vis[a] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        if (cur == b) {
            while (prv[cur] != -1) {
                ans += type[cur];
                cur = prv[cur];
            }

            reverse(ans.begin(), ans.end());
            return;
        }

        int d1 = cur * 2 % 10000;
        if (!vis[d1]) {
            q.push(d1);
            vis[d1] = true;
            prv[d1] = cur;
            type[d1] = 'D';
        }

        int d2 = (cur - 1 + 10000) % 10000;
        if (!vis[d2]) {
            q.push(d2);
            vis[d2] = true;
            prv[d2] = cur;
            type[d2] = 'S';
        }

        int d3 = cur % 1000 * 10 + cur / 1000;
        if (!vis[d3]) {
            q.push(d3);
            vis[d3] = true;
            prv[d3] = cur;
            type[d3] = 'L';
        }

        int d4 = cur % 10 * 1000 + cur / 10;
        if (!vis[d4]) {
            q.push(d4);
            vis[d4] = true;
            prv[d4] = cur;
            type[d4] = 'R';
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;

        memset(vis, 0, sizeof(vis));
        memset(prv, -1, sizeof(prv));
        memset(type, 0, sizeof(type));
        ans = "";

        bfs(a, b);
        cout << ans << '\n';
    }
}
