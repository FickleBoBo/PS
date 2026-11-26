import sys

input = sys.stdin.readline

n = int(input())
for i in range(1, n + 1):
    line = input().rstrip()
    print(f"{i}. {line}")
