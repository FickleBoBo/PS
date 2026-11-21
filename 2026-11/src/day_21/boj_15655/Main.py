import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
out = [" ".join(map(str, seq)) for seq in combinations(arr, m)]
print("\n".join(out))
