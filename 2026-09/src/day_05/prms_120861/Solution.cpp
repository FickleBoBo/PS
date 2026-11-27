#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    int x = 0, y = 0;
    int maxX = board[0] / 2, maxY = board[1] / 2;

    for (string& s : keyinput) {
        if (s == "up") {
            y = min(y + 1, maxY);
        } else if (s == "down") {
            y = max(y - 1, -maxY);
        } else if (s == "left") {
            x = max(x - 1, -maxX);
        } else {
            x = min(x + 1, maxX);
        }
    }

    return {x, y};
}
