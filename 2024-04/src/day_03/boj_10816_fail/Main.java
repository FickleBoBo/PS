package day_03.BOJ_S4_10816_Fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i<N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int j=0 ; j<M ; j++) {
			
			int n = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = M-1;
			int mid = (start + end) / 2;
			int a=0;
			int b=1;
			
			while(start <= end) {
				mid = (start + end) / 2;
				
				if(input[mid] < n) {
					start = mid + 1;
				}
				else if(input[mid] > n) {
					end = mid - 1;
				}
				else {
					a = -1;
					b = N;
					for(int i=mid ; i<N ; i++) {
						if(input[i] != n) {
							b = i;
							break;
						}
					}
					for(int i=mid ; i>=0 ; i--) {
						if(input[i] != n) {
							a = i;
							break;
						}
					}
					break;
				}
			}
			sb.append(b-a-1 + " ");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
	
}
