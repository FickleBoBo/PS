import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
out = [" ".join(map(str, seq)) for seq in sorted(set(permutations(arr, m)))]
print("\n".join(out))
