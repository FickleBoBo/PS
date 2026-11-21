import sys

input = sys.stdin.readline

arr = [int(input()) for _ in range(7)]
odds = [x for x in arr if x % 2]
if odds:
    print(sum(odds))
    print(min(odds))
else:
    print(-1)
