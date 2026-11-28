#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 10000;
int q[MAX_N];
int s = 0, e = 0;

void push(int x) {
    q[e++] = x;
}

void pop() {
    s++;
}

int size() {
    return e - s;
}

bool empty() {
    return s == e;
}

int front() {
    return q[s];
}

int back() {
    return q[e - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string op;
        cin >> op;

        if (op == "push") {
            int x;
            cin >> x;
            push(x);
        } else if (op == "pop") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
                pop();
            }
        } else if (op == "size") {
            cout << size() << '\n';
        } else if (op == "empty") {
            cout << empty() << '\n';
        } else if (op == "front") {
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
