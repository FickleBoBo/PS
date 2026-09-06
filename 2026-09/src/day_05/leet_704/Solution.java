package day_05.leet_704;

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
