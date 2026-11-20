import sys

sys.setrecursionlimit(10**6)


def solution(tickets):
    tickets.sort(key=lambda t: t[1])
    vis = [False] * len(tickets)
    ans = ["ICN"]

    def dfs(cur, depth):
        if depth == len(tickets):
            return True

        for i in range(len(tickets)):
            if vis[i]:
                continue
            if tickets[i][0] != cur:
                continue

            ans.append(tickets[i][1])
            vis[i] = True

            if dfs(tickets[i][1], depth + 1):
                return True

            ans.pop()
            vis[i] = False

        return False

    dfs("ICN", 0)

    return ans
