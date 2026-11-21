import sys
from itertools import combinations

input = sys.stdin.readline

while True:
    k, *arr = map(int, input().split())
    if k == 0:
        break
    for seq in combinations(arr, 6):
        print(*seq)
    print()
