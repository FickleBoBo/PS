import sys

input = sys.stdin.readline

print(max(int(s[::-1]) for s in input().split()))
