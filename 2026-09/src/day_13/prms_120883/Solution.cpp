#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db) {
    for (auto& row : db) {
        if (id_pw[0] != row[0]) continue;
        return id_pw[1] == row[1] ? "login" : "wrong pw";
    }

    return "fail";
}
