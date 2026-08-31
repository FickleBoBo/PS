#include <bits/stdc++.h>
using namespace std;

int solution(string myString, string pat) {
    for (char& c : myString) c = tolower(c);
    for (char& c : pat) c = tolower(c);

    return myString.find(pat) != -1;
}
