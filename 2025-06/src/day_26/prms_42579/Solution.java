package day_26.PRMS_42579;

import java.util.*;

class Solution {

    // 노래 통계 클래스
    private static class MusicStat implements Comparable<MusicStat> {
        String genre;
        int play;

        public MusicStat(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(MusicStat o) {
            return Integer.compare(o.play, this.play);
        }
    }

    // 노래 클래스
    private static class Music implements Comparable<Music> {
        int id;
        String genre;
        int play;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(o.play, this.play);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;

        // key: 장르, value: 장르의 전체 재생된 횟수
        Map<String, Integer> statMap = new HashMap<>();

        // key: 장르, value: 장르별 노래 클래스를 담은 우선순위 큐
        Map<String, PriorityQueue<Music>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String genre = genres[i];
            int play = plays[i];

            statMap.put(genre, statMap.getOrDefault(genre, 0) + play);

            map.putIfAbsent(genre, new PriorityQueue<>());
            map.get(genre).add(new Music(i, genre, play));
        }

        // 노래 통계를 재생된 횟수에 대한 내림차순을 구하기 위해 우선순위 큐 사용
        PriorityQueue<MusicStat> statPq = new PriorityQueue<>();
        statMap.forEach((k, v) -> statPq.add(new MusicStat(k, v)));

        List<Integer> list = new ArrayList<>();
        while (!statPq.isEmpty()) {
            String genre = statPq.remove().genre;

            PriorityQueue<Music> pq = map.get(genre);
            int cnt = 0;

            // 장르별 최대 2곡만 수록
            while (!pq.isEmpty()) {
                list.add(pq.remove().id);
                cnt++;

                if (cnt == 2) break;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
