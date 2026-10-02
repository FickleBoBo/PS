package day_20.SSAFY_PRO_NO4;

import java.util.*;

// 학생 클래스
// 학년과 성별 정보는 학생 클래스에서는 필요없다
// TreeSet의 Key로 사용해서 Comparable, equals, hashCode 오버라이딩
class Student implements Comparable<Student> {
    int id;
    int score;

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score != o.score) return Integer.compare(this.score, o.score);
        return Integer.compare(this.id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }
}

class UserSolution {

    // 입력값 범위
    final int MAX_ID = 1_000_000_000;
    final int MAX_SCORE = 300_000;

    // key : 학년 + 성별, value : 학생그룹
    Map<Integer, TreeSet<Student>> map = new HashMap<>();
    // key : Id, value : 학년 + 성별
    Map<Integer, Integer> idAndKeyMap = new HashMap<>();
    // key : Id, value : 학생
    Map<Integer, Student> idAndStudentMap = new HashMap<>();

    public void init() {
        map.put(1 + 'm', new TreeSet<>());
        map.put(2 + 'm', new TreeSet<>());
        map.put(3 + 'm', new TreeSet<>());
        map.put(1 + 'f', new TreeSet<>());
        map.put(2 + 'f', new TreeSet<>());
        map.put(3 + 'f', new TreeSet<>());
//        System.out.println("시작");
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        int key = mGrade + mGender[0];

        map.get(key).add(new Student(mId, mScore));
        idAndKeyMap.put(mId, key);
        idAndStudentMap.put(mId, new Student(mId, mScore));

//        System.out.println(map.get(key).last().id);
        return map.get(key).last().id;
    }

    public int remove(int mId) {
        int key = idAndKeyMap.getOrDefault(mId, 0);
        if (key == 0) {
//            System.out.println(0);
            return 0;
        }

        Student student = idAndStudentMap.get(mId);
        map.get(key).remove(student);
        idAndKeyMap.remove(mId);
        idAndStudentMap.remove(mId);

        if (map.get(key).isEmpty()) {
//            System.out.println(0);
            return 0;
        }

//        System.out.println(map.get(key).first().id);
        return map.get(key).first().id;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        Set<Integer> keySet = new HashSet<>();
        for (int i = 0; i < mGradeCnt; i++) {
            for (int j = 0; j < mGenderCnt; j++) {
                keySet.add(mGrade[i] + mGender[j][0]);
            }
        }

        int ansId = 0;
        int ansScore = MAX_SCORE;

        for (int key : keySet) {
            // 왜 ceiling인데 -1을 해줘야 잘 찾는지 모르겠음
            Student ceiling = map.get(key).ceiling(new Student(MAX_ID, mScore - 1));

            if (ceiling == null) continue;

            if (ceiling.score == ansScore) {
                ansId = Math.min(ansId, ceiling.id);
            } else if (ceiling.score < ansScore) {
                ansId = ceiling.id;
                ansScore = ceiling.score;
            }
        }

//        System.out.println(ansId);
        return ansId;
    }
}
