import sys

input = sys.stdin.readline

sum_a, sum_b = 100, 100

n = int(input())
for _ in range(n):
    a, b = map(int, input().split())

    if a > b:
        sum_b -= a
    elif a < b:
        sum_a -= b

print(sum_a)
print(sum_b)
