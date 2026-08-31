package day_31.prms_181885;

import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) list.add(todo_list[i]);
        }

        return list.toArray(new String[0]);
    }
}
