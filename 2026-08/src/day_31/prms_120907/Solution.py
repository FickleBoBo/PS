def solution(quiz):
    ans = []

    for q in quiz:
        x, op, y, _, z = q.split()
        res = int(x) + int(y) if op == "+" else int(x) - int(y)
        ans.append("O" if res == int(z) else "X")

    return ans
