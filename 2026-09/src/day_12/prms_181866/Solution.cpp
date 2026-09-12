#include <bits/stdc++.h>
using namespace std;

vector<string> solution(string myString) {
    vector<string> ans;
    stringstream ss(myString);
    string token;

    while (getline(ss, token, 'x')) {
        if (!token.empty()) ans.push_back(token);
    }
    sort(ans.begin(), ans.end());

    return ans;
}
