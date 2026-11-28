import sys

input = sys.stdin.readline
out = []

MAX_N = 10000


class Queue:
    def __init__(self):
        self.q = [0] * MAX_N
        self.s = 0
        self.e = 0

    def push(self, x):
        self.q[self.e] = x
        self.e += 1

    def pop(self):
        self.s += 1
        return self.q[self.s - 1]

    def size(self):
        return self.e - self.s

    def empty(self):
        return self.s == self.e

    def front(self):
        return self.q[self.s]

    def back(self):
        return self.q[self.e - 1]


queue = Queue()

n = int(input())
for _ in range(n):
    tokens = input().split()
    op = tokens[0]

    if op == "push":
        queue.push(int(tokens[1]))
    elif op == "pop":
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.pop())
    elif op == "size":
        out.append(queue.size())
    elif op == "empty":
        if queue.empty():
            out.append(1)
        else:
            out.append(0)
    elif op == "front":
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.front())
    else:
        if queue.empty():
            out.append(-1)
        else:
            out.append(queue.back())

print("\n".join(map(str, out)))
