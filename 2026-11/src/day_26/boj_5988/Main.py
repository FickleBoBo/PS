import sys

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    k = input().rstrip()

    if int(k[-1]) % 2 == 0:
        print("even")
    else:
        print("odd")
