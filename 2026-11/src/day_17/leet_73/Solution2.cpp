#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    void setZeroes(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        bool first_row_has_0 = false, first_col_has_0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) first_col_has_0 = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) first_row_has_0 = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (first_col_has_0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        if (first_row_has_0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
    }
};
