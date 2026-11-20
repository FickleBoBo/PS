#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 10000;
bool vis[MAX_N];
vector<string> ans;

bool dfs(string& cur, int depth, vector<vector<string>>& tickets) {
    if (depth == tickets.size()) return true;

    for (int i = 0; i < tickets.size(); i++) {
        if (vis[i]) continue;
        if (tickets[i][0] != cur) continue;

        ans.push_back(tickets[i][1]);
        vis[i] = true;

        if (dfs(tickets[i][1], depth + 1, tickets)) return true;

        ans.pop_back();
        vis[i] = false;
    }

    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end(), [](auto& a, auto& b) {
        return a[1] < b[1];
    });
    string start = "ICN";
    ans.push_back(start);

    dfs(start, 0, tickets);

    return ans;
}
