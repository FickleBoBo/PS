#include <bits/stdc++.h>
using namespace std;

string solution(string letter) {
    unordered_map<string, char> morse = {
        {".-", 'a'},   {"-...", 'b'}, {"-.-.", 'c'}, {"-..", 'd'},  {".", 'e'},    {"..-.", 'f'}, {"--.", 'g'},
        {"....", 'h'}, {"..", 'i'},   {".---", 'j'}, {"-.-", 'k'},  {".-..", 'l'}, {"--", 'm'},   {"-.", 'n'},
        {"---", 'o'},  {".--.", 'p'}, {"--.-", 'q'}, {".-.", 'r'},  {"...", 's'},  {"-", 't'},    {"..-", 'u'},
        {"...-", 'v'}, {".--", 'w'},  {"-..-", 'x'}, {"-.--", 'y'}, {"--..", 'z'}};

    stringstream ss(letter);
    string ans;
    string code;
    while (ss >> code) {
        ans += morse[code];
    }

    return ans;
}
