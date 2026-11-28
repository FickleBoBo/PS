import sys

input = sys.stdin.readline

n, m = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(n)]
for row in mat:
    arr = list(map(int, input().split()))
    print(*[a + b for a, b in zip(row, arr)])
