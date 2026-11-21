import sys

input = sys.stdin.readline

print(*sorted(map(int, input().split())))
