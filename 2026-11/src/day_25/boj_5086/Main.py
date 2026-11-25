import sys

input = sys.stdin.readline

out = []
while True:
    a, b = map(int, input().split())
    if a == 0:
        break

    if a % b == 0:
        out.append("multiple")
    elif b % a == 0:
        out.append("factor")
    else:
        out.append("neither")

print("\n".join(out))
