#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    vector<string> v;
    stringstream ss(s);
    string token;
    while (ss >> token) v.push_back(token);

    int sum = 0;
    for (int i = 0; i < v.size(); i++) {
        if (v[i] == "Z") {
            sum -= stoi(v[i - 1]);
        } else {
            sum += stoi(v[i]);
        }
    }

    return sum;
}
