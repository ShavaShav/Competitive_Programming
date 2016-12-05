import java.util.Scanner;

public class Palindromes401 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] rev = new char[][]{{'E','3'},{'J','L'},{'L','J'},{'S','2'},{'Z','5'},{'2','S'},{'3','E'},{'5','Z'}};
		String s = sc.nextLine();
		while (!s.isEmpty()){
			String finals = s;
			for (int i = 0; i < s.length(); i++){
				if (s.charAt(i) == '0'){
					s = s.substring(0,i)+'O'+s.substring(i+1);
				}
			}
			boolean isMirrorString = false;
			boolean isMirroredPalindrome = false;
			boolean isPalindrome = true;
			
			for (int i = 0, j = s.length()-1; i <= j; i++, j--){
				if (s.charAt(i) != s.charAt(j))
					isPalindrome =false;
			}
			
			if (isPalindrome){
				String mirroredPal = s;
				boolean changed = false;
				for (int k = 0; k < s.length(); k++){
					char key = mirroredPal.charAt(k);
					for (int q = 0; q < 8; q++){
						if (key == rev[q][0]){
							changed = true;
							mirroredPal = mirroredPal.substring(0, k) + rev[q][1] + mirroredPal.substring(k+1);
						}
						switch (key){
							case 'A': changed = true;
								break;
							case 'H': changed = true;
								break;
							case 'I': changed = true;
								break;
							case 'M': changed = true;
								break;
							case 'O': changed = true;
								break;
							case 'T': changed = true;
								break;
							case 'U': changed = true;
								break;
							case 'V': changed = true;
								break;
							case 'W': changed = true;
								break;
							case 'Y': changed = true;
								break;
							case '1': changed = true;
								break;
							case '8': changed = true;
								break;
							default: break;
						}
					}
				}
				if (s.equals(mirroredPal) && changed){
					isMirroredPalindrome = true;
					for (int t = 0, r = s.length()-1; t < s.length(); t++, r--){
						if (mirroredPal.charAt(r) != s.charAt(t)){
							isMirroredPalindrome = false;
						}
					}
				}
			}
			else{
				isMirrorString = true;
				String mirroredS = s;
				for (int k = 0; k < s.length(); k++){
					char key = mirroredS.charAt(k);
					for (int q = 0; q < 8; q++){
						if (key == rev[q][0]){
							mirroredS = mirroredS.substring(0, k) + rev[q][1] + mirroredS.substring(k+1);
						}
					}
				}
				for (int t = 0, r = s.length()-1; t < s.length(); t++, r--){
					if (mirroredS.charAt(r) != s.charAt(t)){
						isMirrorString = false;
					}
				}
			}
			boolean isMirrored = true;
			for (int i = 0; i < s.length(); i++){
				switch (s.charAt(i)){
					case 'B': isMirrored = false;
						break;
					case 'C': isMirrored = false;
						break;
					case 'D': isMirrored = false;
						break;
					case 'F': isMirrored = false;
						break;
					case 'G': isMirrored = false;
						break;
					case 'K': isMirrored = false;
						break;
					case 'N': isMirrored = false;
						break;
					case 'P': isMirrored = false;
						break;
					case 'Q': isMirrored = false;
						break;
					case 'R': isMirrored = false;
						break;
					case '4': isMirrored = false;
						break;
					case '6': isMirrored = false;
						break;
					case '7': isMirrored = false;
						break;
					case '9': isMirrored = false;
						break;
					default: break;				
				}
			}
			if (isMirroredPalindrome && isMirrored){
				System.out.println(finals + "-- is a mirrored palindrome.\n");
			} else if (isPalindrome){
				System.out.println(finals + "-- is a regular palindrome.\n");
			} else if (isMirrorString && isMirrored){
				System.out.println(finals + "-- is a mirrored string.\n");
			} else {
				System.out.println(finals + "-- is not a palindrome.\n");
			}
			if (sc.hasNext())
				s = sc.nextLine();
			else
				break;
		}
		sc.close();
	}
}
