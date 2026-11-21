import sys

input = sys.stdin.readline

n, k = map(int, input().split())
out = [x for x in map(int, input().split()) if x < k]
print(*out)
