#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> pos(2);
    int maxx = board[0] / 2;
    int maxy = board[1] / 2;

    for (string& s : keyinput) {
        if (s == "up") {
            pos[1] = min(pos[1] + 1, maxy);
        } else if (s == "down") {
            pos[1] = max(pos[1] - 1, -maxy);
        } else if (s == "left") {
            pos[0] = max(pos[0] - 1, -maxx);
        } else {
            pos[0] = min(pos[0] + 1, maxx);
        }
    }

    return pos;
}
