import sys

input = sys.stdin.readline

MAX_N = 1_000_000


class Stack:
    def __init__(self):
        self.st = [0] * MAX_N
        self.pos = 0

    def push(self, x):
        self.st[self.pos] = x
        self.pos += 1

    def pop(self):
        self.pos -= 1
        return self.st[self.pos]

    def size(self):
        return self.pos

    def empty(self):
        return self.pos == 0

    def top(self):
        return self.st[self.pos - 1]


stack = Stack()
out = []

n = int(input())
for _ in range(n):
    q = input().split()

    if q[0] == "1":
        stack.push(int(q[1]))
    elif q[0] == "2":
        if stack.empty():
            out.append(-1)
        else:
            out.append(stack.pop())
    elif q[0] == "3":
        out.append(stack.size())
    elif q[0] == "4":
        if stack.empty():
            out.append(1)
        else:
            out.append(0)
    else:
        if stack.empty():
            out.append(-1)
        else:
            out.append(stack.top())

print("\n".join(map(str, out)))
