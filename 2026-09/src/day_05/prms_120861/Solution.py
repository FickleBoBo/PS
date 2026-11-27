def solution(keyinput, board):
    x, y = 0, 0
    max_x, max_y = board[0] // 2, board[1] // 2

    for s in keyinput:
        if s == "up":
            y = min(y + 1, max_y)
        elif s == "down":
            y = max(y - 1, -max_y)
        elif s == "left":
            x = max(x - 1, -max_x)
        else:
            x = min(x + 1, max_x)

    return [x, y]
