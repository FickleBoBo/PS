# [BOJ 1874 - 스택 수열](https://www.acmicpc.net/problem/1874)

## 문제

스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

## 입력

첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

## 출력

입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

## 예제 입력 1

```
8
4
3
6
8
7
5
2
1
```

## 예제 출력 1

```
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
```

## 예제 입력 2

```
5
1
2
5
3
4
```

## 예제 출력 2

```
NO
```

## 힌트

1부터 n까지에 수에 대해 차례로 [push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop] 연산을 수행하면 수열 [4, 3, 6, 8, 7, 5, 2, 1]을 얻을 수 있다.

---

## 문제 정보

| 티어          | 실버 2          |
| ------------- | --------------- |
| 시간 제한     | 2초             |
| 메모리 제한   | 128 MB          |
| 알고리즘 분류 | 자료 구조, 스택 |

## 풀이 정보

| 풀이 시간 | 52 min   |
| --------- | -------- |
| 시간      | 292 ms   |
| 메모리    | 26968 KB |
| 코드 길이 | 1348 B   |

## 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        boolean isPossible = true;  // 스택 수열 가능 여부
        int num = 1;  // 1 ~ N 까지 입력 수열
        int before = 0;  // 이전 수

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            // 이전 수보다 크면 스택에 쭉 넣고 팝
            if (input > before) {
                for (int j = num; j <= input; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }

                num = input + 1;

                stack.pop();
                sb.append("-\n");
            }
            // 이전 수보다 작으면 팝
            else {
                if (stack.isEmpty() || stack.peek() != input) {
                    isPossible = false;
                    break;
                }

                stack.pop();
                sb.append("-\n");
            }

            before = input;
        }

        if (isPossible) {
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }
}
```

## 리뷰

- 주어진 수열에 대해 현재 수와 이전 수를 비교하는 방식으로 스택 수열 여부를 판단했는데 스택에 삽입하는 로직을 찾는게 좀 어려웠다.
- 1 ~ N 까지 최소 수열을 통해 스택 수열이 만들어지는지 판단하는 로직을 찾는게 좀 어려웠다.
