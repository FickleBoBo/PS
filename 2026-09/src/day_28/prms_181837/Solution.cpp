#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> order) {
    int sum = 0;
    for (string& s : order) {
        sum += s.find("cafelatte") != -1 ? 5000 : 4500;
    }

    return sum;
}
