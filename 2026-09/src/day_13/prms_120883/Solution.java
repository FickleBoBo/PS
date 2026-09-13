package day_13.prms_120883;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] row : db) {
            if (!id_pw[0].equals(row[0])) continue;
            return id_pw[1].equals(row[1]) ? "login" : "wrong pw";
        }

        return "fail";
    }
}
