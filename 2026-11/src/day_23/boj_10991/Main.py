import sys

input = sys.stdin.readline

n = int(input())

for i in range(1, n + 1):
    line = " " * (n - i)
    for j in range(1, 2 * i):
        if j % 2:
            line += "*"
        else:
            line += " "
    print(line)
