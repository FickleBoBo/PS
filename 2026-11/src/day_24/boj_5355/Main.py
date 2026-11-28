import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    tokens = input().split()
    x = float(tokens[0])

    for op in tokens[1:]:
        if op == "@":
            x *= 3
        elif op == "%":
            x += 5
        else:
            x -= 7

    print(f"{x:.2f}")
