import sys

input = sys.stdin.readline
out = []

MAX_N = 10000


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

n = int(input())
for _ in range(n):
    tokens = input().split()
    op = tokens[0]

    if op == "push":
        stack.push(int(tokens[1]))
    elif op == "pop":
        if stack.empty():
            out.append(-1)
        else:
            out.append(stack.pop())
    elif op == "size":
        out.append(stack.size())
    elif op == "empty":
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
