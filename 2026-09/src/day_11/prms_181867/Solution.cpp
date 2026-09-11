#include <bits/stdc++.h>
using namespace std;

vector<int> solution(string myString) {
    int n = myString.size();
    vector<int> v;
    int prv = 0;

    for (int i = 0; i < n; i++) {
        if (myString[i] == 'x') {
            v.push_back(i - prv);
            prv = i + 1;
        }
    }
    v.push_back(n - prv);

    return v;
}
