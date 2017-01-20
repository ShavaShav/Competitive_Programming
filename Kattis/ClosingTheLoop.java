import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClosingTheLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tests = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= tests; i++){
			PriorityQueue<Integer> red = 
					new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> blue =
					new PriorityQueue<Integer>(Collections.reverseOrder());
			sc.nextLine();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			while (st.hasMoreTokens()){
				String thread = st.nextToken();
				char color = thread.charAt(thread.length()-1);
				int threadLen = Integer.parseInt(thread.substring(0, thread.length()-1));
				if (color == 'R')
					red.add(threadLen);
				else
					blue.add(threadLen);
			}

			int len = 0; // if missing a match, then length is 0
			if (!red.isEmpty() && !blue.isEmpty()){
				PriorityQueue<Integer> first;
				PriorityQueue<Integer> second;
				if (red.peek() > blue.peek()){	
					first = red;
					second = blue;
				} else {
					first = blue;
					second = red;
				}

				while (!first.isEmpty() && !second.isEmpty()){
					len += first.poll()-1;
					len += second.poll()-1;
				}
			}
			System.out.println("Case #"+i+": "+len);
		}
		sc.close();
	}

}
