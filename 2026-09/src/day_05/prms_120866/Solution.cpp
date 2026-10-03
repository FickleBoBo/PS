#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 100;
bool vis[MAX_N][MAX_N];
int dr[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dc[8] = {-1, 0, 1, 1, 1, 0, -1, -1};

int solution(vector<vector<int>> board) {
    int n = board.size();

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (board[r][c]) {
                vis[r][c] = true;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    vis[nr][nc] = true;
                }
            }
        }
    }

    int cnt = 0;
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (!vis[r][c]) cnt++;
        }
    }

    return cnt;
}
