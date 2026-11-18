#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        int top = 0, bottom = matrix.size() - 1;
        int left = 0, right = matrix[0].size() - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) ans.push_back(matrix[top][c]);
            top++;

            for (int r = top; r <= bottom; r++) ans.push_back(matrix[r][right]);
            right--;

            if (top > bottom || left > right) break;

            for (int c = right; c >= left; c--) ans.push_back(matrix[bottom][c]);
            bottom--;

            for (int r = bottom; r >= top; r--) ans.push_back(matrix[r][left]);
            left++;
        }

        return ans;
    }
};
