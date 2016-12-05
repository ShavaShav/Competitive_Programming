import java.util.Scanner;
import java.util.StringTokenizer;

public class ContinuedFractions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, denom, div, rem;
		while (sc.hasNextLine()){
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			num = Integer.parseInt(st.nextToken());
			denom = Integer.parseInt(st.nextToken());
			div = num / denom;
			rem = num % denom;
			num = denom;
			denom = rem;
			String contFract = "[" + div + ";";
			while (denom != 0){
				div = num / denom;
				rem = num % denom;
				num = denom;
				denom = rem;
				if (denom == 0)
					contFract += div;
				else
					contFract += div + ",";
			}
			contFract += "]";
			System.out.println(contFract);
		}
		sc.close();
	}
}
