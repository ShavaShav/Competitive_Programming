import java.util.*;

class Main {
	public static final boolean DEBUG = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string1 = sc.nextLine();
		
		while (sc.hasNext())	// scan to empty line
		{
			String string2 = sc.nextLine();
			int[] string1Ascii = new int[26];
			int[] string2Ascii = new int[26];
			final int offset = 97;	// ASCII table offset
			
			for (int i = 0; i < 26; i++)
			{
				string1Ascii[i] = 0;
				string2Ascii[i] = 0;
			}
			
			for (int i = 0; i < string1.length(); i ++)
			{
				// for each character in string, convert to ascii #, offset
				int charIndex = (int) (string1.charAt(i) - offset);
				string1Ascii[charIndex]++; // set ascii index to true, string has that character
				if (DEBUG) System.out.println((char)(charIndex+offset)+ " " +charIndex+": "+string1Ascii[charIndex]);
			}
			
			if (DEBUG)
			{
				for (int i = 0; i < 26; i++)
					System.out.println((char)(i+offset)+": "+string1Ascii[i]);
			}
			
			
			
			for (int i = 0; i < string2.length(); i ++)
			{
				// for each character in string, convert to ascii #, offset
				int charIndex = (int) (string2.charAt(i) - offset);
				string2Ascii[charIndex]++; // set ascii index to true, string has that character
			}

			// compare tables, output letters up to smaller count
			for (int i = 0; i < 26; i++)
			{
				int charCount;
				if (string1Ascii[i] < string2Ascii[i])
					charCount = string1Ascii[i];
				else
					charCount = string2Ascii[i];
				
				for (int j = 0; j < charCount; j++)
				{
					char current = (char) (i + offset);
					System.out.print(current);					
				}
			}
			System.out.println("");
			
			if (sc.hasNext()) string1 = sc.nextLine();
		}
	}

}
