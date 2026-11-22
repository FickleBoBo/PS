import sys

input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    age, name = input().split()
    arr.append((int(age), name))
arr.sort(key=lambda x: x[0])

print("\n".join(f"{age} {name}" for age, name in arr))
