import sys

input = sys.stdin.readline

n = int(input())

out = []
for i in range(1, n + 1):
    line = ""
    for j in range(1, 2 * n + 1):
        if (i + j) % 2 == 0:
            line += "*"
        else:
            line += " "
    out.append(line)

print("\n".join(out))
