#include <bits/stdc++.h>
using namespace std;

vector<string> solution(string myStr) {
    for (char& c : myStr) {
        if (c == 'a' || c == 'b' || c == 'c') c = ' ';
    }

    stringstream ss(myStr);
    vector<string> ans;
    string token;
    while (ss >> token) ans.push_back(token);

    if (ans.empty()) return {"EMPTY"};
    return ans;
}
