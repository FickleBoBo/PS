package day_06.PRMS_176962;

import java.util.*;

class Solution {

    private static class Item {
        String name;
        int start;
        int playtime;

        public Item(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        // 과제의 시작 시간을 기준으로 정렬
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));

        // 끝낸 과제를 담는 배열과 인덱스
        String[] answer = new String[plans.length];
        int idx = 0;

        Deque<Item> stack = new ArrayDeque<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int start = convert(plan[1]);
            int playtime = Integer.parseInt(plan[2]);

            // 멈춘 과제가 없으면 새로운 과제를 바로 Stack에 넣음
            if (stack.isEmpty()) {
                stack.push(new Item(name, start, playtime));
                continue;
            }

            while (!stack.isEmpty()) {
                Item item = stack.pop();

                // 멈춘 과제를 끝낼 수 있으면 끝내고 다음으로 최근에 멈춘 과제가 있으면 정보 갱신
                if (item.start + item.playtime <= start) {
                    answer[idx++] = item.name;

                    if (stack.isEmpty()) break;

                    Item peek = stack.pop();
                    stack.push(new Item(peek.name, item.start + item.playtime, peek.playtime));
                }
                // 멈춘 과제를 끝낼 수 없으면 멈춘 과제의 정보를 갱신에서 Stack에 넣음
                else {
                    stack.push(new Item(item.name, start, item.playtime - (start - item.start)));
                    break;
                }
            }

            // 새로운 과제를 Stack에 넣음
            stack.push(new Item(name, start, playtime));
        }

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }

    // 00:00 부터 지난 분을 반환하는 메서드로 시작 시간을 편하게 다루기 위해 적용
    private static int convert(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }

}
