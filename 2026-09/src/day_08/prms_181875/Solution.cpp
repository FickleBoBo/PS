#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> strArr) {
    for (int i = 0; i < strArr.size(); i++) {
        if (i % 2) {
            for (char& c : strArr[i]) c = toupper(c);
        } else {
            for (char& c : strArr[i]) c = tolower(c);
        }
    }

    return strArr;
}
