import sys

input = sys.stdin.readline

n, k = map(int, input().split())
print(*[x for x in map(int, input().split()) if x < k])
