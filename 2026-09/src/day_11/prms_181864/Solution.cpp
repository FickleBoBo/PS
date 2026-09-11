#include <bits/stdc++.h>
using namespace std;

int solution(string myString, string pat) {
    for (char& c : myString) {
        c = (c == 'A') ? 'B' : 'A';
    }

    return myString.find(pat) != -1;
}
