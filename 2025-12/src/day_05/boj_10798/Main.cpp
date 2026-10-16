#include <bits/stdc++.h>
using namespace std;

char grid[5][15 + 1];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 5; i++) {
        cin >> grid[i];
    }

    for (int j = 0; j < 15; j++) {
        for (int i = 0; i < 5; i++) {
            if (grid[i][j] != '\0') cout << grid[i][j];
        }
    }
}
