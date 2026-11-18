class Solution:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        ans = []
        top, bottom = 0, len(matrix) - 1
        left, right = 0, len(matrix[0]) - 1

        while top <= bottom and left <= right:
            for c in range(left, right + 1):
                ans.append(matrix[top][c])
            top += 1

            for r in range(top, bottom + 1):
                ans.append(matrix[r][right])
            right -= 1

            if top > bottom or left > right:
                break

            for c in range(right, left - 1, -1):
                ans.append(matrix[bottom][c])
            bottom -= 1

            for r in range(bottom, top - 1, -1):
                ans.append(matrix[r][left])
            left += 1

        return ans
