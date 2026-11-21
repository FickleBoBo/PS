import sys

input = sys.stdin.readline

input()
arr = list(map(int, input().split()))
ys = sum(x // 30 + 1 for x in arr) * 10
ms = sum(x // 60 + 1 for x in arr) * 15

if ys < ms:
    print("Y", ys)
elif ys > ms:
    print("M", ms)
else:
    print("Y M", ys)
