import sys

input = sys.stdin.readline

n = int(input())

out = []
for i in range(1, n + 1):
    line = " " * (n - i)
    for j in range(1, 2 * i):
        if j == 1 or j == 2 * i - 1:
            line += "*"
        else:
            line += " "
    out.append(line)

print("\n".join(out))
