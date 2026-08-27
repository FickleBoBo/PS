package day_26.prms_120844;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] arr = new int[numbers.length];
        if (direction.equals("left")) {
            System.arraycopy(numbers, 1, arr, 0, numbers.length - 1);
            arr[numbers.length - 1] = numbers[0];
        } else {
            System.arraycopy(numbers, 0, arr, 1, numbers.length - 1);
            arr[0] = numbers[numbers.length - 1];
        }

        return arr;
    }
}
