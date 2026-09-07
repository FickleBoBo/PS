#include <bits/stdc++.h>
using namespace std;

vector<string> solution(string my_string) {
    stringstream ss(my_string);
    vector<string> tokens;
    string token;
    while (ss >> token) tokens.push_back(token);

    return tokens;
}
