package day_28.BOJ_S3_17413;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), "< >", true);    // 다 쪼개주고 true 넣어야 함
		StringBuilder sb = new StringBuilder();     // 출력용 스트링 빌더
		StringBuilder sb2 = new StringBuilder();    // 리버스용 스트링 빌더
		
		while(st.hasMoreTokens()) {                 // 다음 단어가 있는 동안 반복
			String tmp = st.nextToken();            // 다음 단어 받기
			
			if(tmp.equals("<")) {                   // 태그가 우선이며 열린 태그를 받으면
				sb.append(tmp);                     // 스트링 빌더에 넣어주고
				String tmp2 = st.nextToken();       // 다음 단어를 받아서
				while(!(tmp2.equals(">"))){         // 닫힌 태그가 나올 때까지
					sb.append(tmp2);                // 스트링 빌더에 넣어주기
					tmp2 = st.nextToken();          // 다음 단어 받기
				}
				sb.append(tmp2);                    // 반복문 탈출하면 남은 닫힌 태크 받아주고 끝
			}
			else {                                  // 일반 단어가 나오면
				sb2.append(tmp);                    // 임시 스트링 빌더에 넣어주고
				sb.append(sb2.reverse());           // 리버스 메서드로 역순으로 넣어주고
				sb2 = new StringBuilder();          // 임시 스트링 빌더 초기화 메서드가 없어서 그냥 새로 인스턴스 할당
			}
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}
}
