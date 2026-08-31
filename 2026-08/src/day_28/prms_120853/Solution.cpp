#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    stringstream ss(s);
    vector<string> tokens;
    string token;
    while (ss >> token) tokens.push_back(token);

    int sum = 0;
    for (int i = 0; i < tokens.size(); i++) {
        if (tokens[i] == "Z") {
            sum -= stoi(tokens[i - 1]);
        } else {
            sum += stoi(tokens[i]);
        }
    }

    return sum;
}
