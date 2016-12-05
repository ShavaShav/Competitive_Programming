import java.util.Scanner;

public class MachinedSurfaces414 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		while (input > 0){
			int[] lineCount = new int[input];
			for (int line = 0; line < input; line++){
				int count = 0;
				String s = sc.nextLine();
				for (int ch = 0; ch < s.length(); ch++){
					if (s.charAt(ch) == 'X'){
						count++;
					}
				}
				lineCount[line] = count;
			}
			int max = 0;
			for (int i = 0; i < input; i++){
				if (lineCount[i] > max){
					max = lineCount[i];
				}
			}
			int sum = 0;
			for (int i = 0; i < input; i++){
				sum += max - lineCount[i];
			}
			System.out.println(sum);
			input = Integer.parseInt(sc.nextLine());
		}
		sc.close();
	}
}
