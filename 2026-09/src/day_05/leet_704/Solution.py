class Solution:
    def binary_search(self, nums, target):
        lo, hi = 0, len(nums) - 1

        while lo <= hi:
            mid = (lo + hi) // 2

            if nums[mid] < target:
                lo = mid + 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                return mid

        return -1

    def search(self, nums: list[int], target: int) -> int:
        return self.binary_search(nums, target)
