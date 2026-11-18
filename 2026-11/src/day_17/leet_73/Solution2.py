class Solution:
    def setZeroes(self, matrix: list[list[int]]) -> None:
        m, n = len(matrix), len(matrix[0])
        first_row_has_0, first_col_has_0 = False, False

        for i in range(m):
            if matrix[i][0] == 0:
                first_col_has_0 = True
        for j in range(n):
            if matrix[0][j] == 0:
                first_row_has_0 = True

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        if first_col_has_0:
            for i in range(m):
                matrix[i][0] = 0
        if first_row_has_0:
            for j in range(n):
                matrix[0][j] = 0
