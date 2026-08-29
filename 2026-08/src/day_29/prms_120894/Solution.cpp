#include <bits/stdc++.h>
using namespace std;

string words[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

long long solution(string numbers) {
    for (int d = 0; d < 10; d++) {
        int pos;
        while ((pos = numbers.find(words[d])) != -1) {
            numbers.replace(pos, words[d].size(), to_string(d));
        }
    }

    return stoll(numbers);
}
