#include <bits/stdc++.h>
using namespace std;

string solution(string myString) {
    for (char& c : myString) {
        if ('a' <= c && c < 'l') c = 'l';
    }

    return myString;
}
