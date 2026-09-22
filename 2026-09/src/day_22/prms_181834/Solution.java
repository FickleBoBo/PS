package day_22.prms_181834;

class Solution {
    public String solution(String myString) {
        char[] arr = myString.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('a' <= arr[i] && arr[i] < 'l') arr[i] = 'l';
        }

        return new String(arr);
    }
}
