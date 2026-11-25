import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    input()
    print(sum(map(int, input().split())))
