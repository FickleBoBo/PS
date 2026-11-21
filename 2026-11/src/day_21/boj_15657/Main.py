import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))
out = [" ".join(map(str, seq)) for seq in combinations_with_replacement(arr, m)]
print("\n".join(out))
