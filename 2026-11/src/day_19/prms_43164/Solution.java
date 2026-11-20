package day_19.prms_43164;

import java.util.*;

class Solution {

    static boolean[] vis;
    static List<String> ans = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        vis = new boolean[tickets.length];
        ans.add("ICN");

        dfs("ICN", 0, tickets);

        return ans.toArray(new String[0]);
    }

    static boolean dfs(String cur, int depth, String[][] tickets) {
        if (depth == tickets.length) return true;

        for (int i = 0; i < tickets.length; i++) {
            if (vis[i]) continue;
            if (!tickets[i][0].equals(cur)) continue;

            ans.add(tickets[i][1]);
            vis[i] = true;

            if (dfs(tickets[i][1], depth + 1, tickets)) return true;

            ans.removeLast();
            vis[i] = false;
        }

        return false;
    }
}
