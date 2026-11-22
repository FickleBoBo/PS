import sys

input = sys.stdin.readline

input()
arr = list(map(int, input().split()))
v = int(input())

print(arr.count(v))
