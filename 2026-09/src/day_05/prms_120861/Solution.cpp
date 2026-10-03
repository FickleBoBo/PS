#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    int x = 0, y = 0;
    int maxx = board[0] / 2, maxy = board[1] / 2;

    for (string& s : keyinput) {
        if (s == "up") {
            y = min(y + 1, maxy);
        } else if (s == "down") {
            y = max(y - 1, -maxy);
        } else if (s == "left") {
            x = max(x - 1, -maxx);
        } else {
            x = min(x + 1, maxx);
        }
    }

    return {x, y};
}
