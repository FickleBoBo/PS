import sys

input = sys.stdin.readline

n = int(input())

for i in range(1, n):
    line = " " * (n - i)
    for j in range(1, 2 * i):
        if j == 1 or j == 2 * i - 1:
            line += "*"
        else:
            line += " "
    print(line)
print("*" * (2 * n - 1))
