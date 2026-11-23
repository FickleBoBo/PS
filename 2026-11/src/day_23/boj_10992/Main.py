import sys

input = sys.stdin.readline

n = int(input())

out = []
for i in range(1, n):
    line = " " * (n - i)
    for j in range(1, 2 * i):
        if j == 1 or j == 2 * i - 1:
            line += "*"
        else:
            line += " "
    out.append(line)
out.append("*" * (2 * n - 1))

print("\n".join(out))
