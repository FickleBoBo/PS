#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    stringstream ss(s);
    string token;
    int sum = 0;
    int prv = 0;

    while (ss >> token) {
        if (token == "Z") {
            sum -= prv;
        } else {
            int x = stoi(token);
            sum += x;
            prv = x;
        }
    }

    return sum;
}
