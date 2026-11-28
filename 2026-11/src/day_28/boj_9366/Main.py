import sys

input = sys.stdin.readline

t = int(input())
for tc in range(1, t + 1):
    a, b, c = map(int, input().split())

    if a >= b + c or b >= a + c or c >= a + b:
        res = "invalid!"
    elif a == b == c:
        res = "equilateral"
    elif a == b or b == c or c == a:
        res = "isosceles"
    else:
        res = "scalene"

    print(f"Case #{tc}: {res}")
