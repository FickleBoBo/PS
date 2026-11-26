#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 10000;
int dq[MAX_N * 2];
int s = MAX_N, e = MAX_N;

void push_front(int x) {
    dq[--s] = x;
}

void push_back(int x) {
    dq[e++] = x;
}

void pop_front() {
    s++;
}

void pop_back() {
    e--;
}

int size() {
    return e - s;
}

bool empty() {
    return s == e;
}

int front() {
    return dq[s];
}

int back() {
    return dq[e - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string q;
        cin >> q;

        if (q == "push_front") {
            int x;
            cin >> x;
            push_front(x);
        } else if (q == "push_back") {
            int x;
            cin >> x;
            push_back(x);
        } else if (q == "pop_front") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
                pop_front();
            }
        } else if (q == "pop_back") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
                pop_back();
            }
        } else if (q == "size") {
            cout << size() << '\n';
        } else if (q == "empty") {
            cout << empty() << '\n';
        } else if (q == "front") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
            }
        } else {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
            }
        }
    }
}
