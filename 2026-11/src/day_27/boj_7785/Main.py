import sys

input = sys.stdin.readline

st = set()

n = int(input())
for _ in range(n):
    name, action = input().split()
    if action == "enter":
        st.add(name)
    else:
        st.remove(name)

print("\n".join(sorted(st, reverse=True)))
