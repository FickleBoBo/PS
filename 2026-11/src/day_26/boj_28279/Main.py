import sys

input = sys.stdin.readline
out = []

MAX_N = 1_000_000


class Deque:
    def __init__(self):
        self.dq = [0] * (MAX_N * 2)
        self.s = MAX_N
        self.e = MAX_N

    def push_front(self, x):
        self.s -= 1
        self.dq[self.s] = x

    def push_back(self, x):
        self.dq[self.e] = x
        self.e += 1

    def pop_front(self):
        self.s += 1
        return self.dq[self.s - 1]

    def pop_back(self):
        self.e -= 1
        return self.dq[self.e]

    def size(self):
        return self.e - self.s

    def empty(self):
        return self.s == self.e

    def front(self):
        return self.dq[self.s]

    def back(self):
        return self.dq[self.e - 1]


deque = Deque()

n = int(input())
for _ in range(n):
    tokens = input().split()
    op = tokens[0]

    if op == "1":
        deque.push_front(int(tokens[1]))
    elif op == "2":
        deque.push_back(int(tokens[1]))
    elif op == "3":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.pop_front())
    elif op == "4":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.pop_back())
    elif op == "5":
        out.append(deque.size())
    elif op == "6":
        if deque.empty():
            out.append(1)
        else:
            out.append(0)
    elif op == "7":
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.front())
    else:
        if deque.empty():
            out.append(-1)
        else:
            out.append(deque.back())

print("\n".join(map(str, out)))
