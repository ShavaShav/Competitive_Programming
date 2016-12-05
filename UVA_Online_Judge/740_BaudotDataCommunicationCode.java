import java.util.Scanner;

public class BaudotDataCommunicationCode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String downShift = sc.nextLine();
		String upShift = sc.nextLine();
		while (sc.hasNextLine()){
			boolean inDownShift = true;
			String bin = sc.nextLine();
			
			for (int i = 0; i < bin.length(); i+=5){
				String bin5 = bin.substring(i, i+5);
				int baudot = Integer.parseInt(bin5, 2);
				if (baudot == 27) 
					inDownShift = true;
				else if (baudot == 31)
					inDownShift = false;
				else{
					String key;
					if (inDownShift)
						System.out.print(downShift.charAt(baudot));
					else
						System.out.print(upShift.charAt(baudot));
				}				
			}
			System.out.println();
		}
		sc.close();
	}

}
