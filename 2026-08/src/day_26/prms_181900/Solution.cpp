#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, vector<int> indices) {
    for (int i : indices) {
        my_string[i] = '\0';
    }
    erase(my_string, '\0');

    return my_string;
}
