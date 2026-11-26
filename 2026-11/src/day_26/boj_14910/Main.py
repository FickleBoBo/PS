import sys

input = sys.stdin.readline

arr = list(map(int, input().split()))
print("Good" if arr == sorted(arr) else "Bad")
