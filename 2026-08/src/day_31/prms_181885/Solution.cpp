#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> todo_list, vector<bool> finished) {
    vector<string> v;
    for (int i = 0; i < todo_list.size(); i++) {
        if (!finished[i]) v.push_back(todo_list[i]);
    }

    return v;
}
