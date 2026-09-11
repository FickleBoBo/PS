#include <bits/stdc++.h>
using namespace std;

int solution(string myString, string pat) {
    int cnt = 0;
    for (int i = 0; i < myString.size(); i++) {
        if (myString.find(pat, i) == i) cnt++;
    }

    return cnt;
}
