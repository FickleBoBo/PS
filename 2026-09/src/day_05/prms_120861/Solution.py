def solution(keyinput, board):
    x, y = 0, 0
    maxx, maxy = board[0] // 2, board[1] // 2

    for s in keyinput:
        if s == "up":
            y = min(y + 1, maxy)
        elif s == "down":
            y = max(y - 1, -maxy)
        elif s == "left":
            x = max(x - 1, -maxx)
        else:
            x = min(x + 1, maxx)

    return [x, y]
