import sys

input = sys.stdin.readline

a, b = map(int, input().split())
arr = []
num = 1
while len(arr) < b:
    arr.extend([num] * num)
    num += 1

print(sum(arr[a - 1 : b]))
