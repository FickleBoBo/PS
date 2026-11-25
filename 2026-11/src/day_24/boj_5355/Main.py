import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    tokens = input().split()
    x = float(tokens[0])

    for c in tokens[1:]:
        if c == "@":
            x *= 3
        elif c == "%":
            x += 5
        else:
            x -= 7

    print(f"{x:.2f}")
