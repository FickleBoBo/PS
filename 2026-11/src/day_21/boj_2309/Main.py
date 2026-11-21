import sys
from itertools import combinations

input = sys.stdin.readline

arr = sorted(int(input()) for _ in range(9))
for seven in combinations(arr, 7):
    if sum(seven) == 100:
        print(*seven, sep="\n")
        break
