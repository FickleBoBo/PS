import sys

input = sys.stdin.readline

out = []
while True:
    a, b = map(int, input().split())

    if a == 0:
        break

    if a > b:
        out.append("Yes")
    else:
        out.append("No")

print("\n".join(out))
