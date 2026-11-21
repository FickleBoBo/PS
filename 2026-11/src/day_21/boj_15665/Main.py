import sys
from itertools import product

input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(set(map(int, input().split())))
out = [" ".join(map(str, seq)) for seq in product(arr, repeat=m)]
print("\n".join(out))
