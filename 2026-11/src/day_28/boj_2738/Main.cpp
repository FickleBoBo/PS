#include <bits/stdc++.h>
using namespace std;

int mat[100][100];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int k = 0; k < 2; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x;
                cin >> x;
                mat[i][j] += x;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << mat[i][j] << ' ';
        }
        cout << '\n';
    }
}
