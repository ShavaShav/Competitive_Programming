import java.util.Scanner;
import java.util.StringTokenizer;

// Started this out in a functional programming style, hence all the statics
// Ended up doing a more object oriented solution
public class MirrorMirror {
	private static Scanner sc = new Scanner(System.in);
	
	public static class Arrays{
		char[][] original;
		char[][] transformation;
		int size;
		
		public boolean areEqual()
		{
			return java.util.Arrays.deepEquals(original, transformation);
		}
		
		public void flipVertical()
		{
			char[][] flipped = new char[size][size];
			int top = 0, bottom = size-1;
			
			// mirror the array by row
			while ( top <= bottom )
			{
				for (int i = 0; i < size; i++)
				{
					flipped[top][i] = original[bottom][i];
					flipped[bottom][i] = original[top][i];
				}
				top++;
				bottom--;
			}
			original = flipped;
		}
		
		public void rotate90()
		{
			char[][] rotated = new char[size][size];
			
			for (int oRow = 0, rCol = size-1; oRow < size; oRow++, rCol--)
				for (int i = 0; i < size; i++)
					rotated[i][rCol] = original[oRow][i];
			
			original = rotated;
		}
	}	// end of Arrays inner class
	
	private static Arrays readArrays(int size)
	{
		// Initalize arrays object
		Arrays arrays = new Arrays();
		arrays.size = size;
		arrays.original = new char[size][size];
		arrays.transformation = new char[size][size];

		for (int i = 0; i < size; i++)
		{
			// get line, 2 arrays per line seperated by space
			StringTokenizer lineTok = new StringTokenizer(sc.nextLine(), " ");
			
			// row of array to be transformed
			String arrayRow = lineTok.nextToken();
			for (int j = 0; j < size; j++)
				arrays.original[i][j] = arrayRow.charAt(j);
			
			// row of transformed array
			arrayRow = lineTok.nextToken();
			for (int j = 0; j < size; j++)
				arrays.transformation[i][j] = arrayRow.charAt(j);
		}
		return arrays;
	} // end of readArrays()
	
	public static void main (String[] args)
	{
		int patternNo = 1;
		while (sc.hasNextLine())	// to end of input
		{
			int size = Integer.parseInt(sc.nextLine());	// get size of square array
			Arrays arrays = readArrays(size);	// get arrays
			
			if (arrays.areEqual())
				System.out.println("Pattern " + patternNo + " was preserved.");
			else
			{
				int rotations = 0;
				
				// do transformations
				while (rotations < 8) 
				{
					if (rotations == 4) // 4 rotations = original so flip
						arrays.flipVertical();
					
					if (arrays.areEqual()) 
						break; // break to printouts if same
					
					arrays.rotate90();	// else rotate
					rotations++;
				} // ends in original position, no more transformations possible
				
				if (rotations == 8)	// rotations were exhausted
				{
					System.out.println("Pattern " + patternNo + " was improperly transformed.");
				}
				else
				{
					// Rotated and/or flipped
					System.out.print("Pattern " + patternNo + " was ");
					
					if (rotations >= 4) // flipped vertically in some way
						System.out.print("reflected vertically");
					
					if (rotations > 4)	// more than just a flip needed
						System.out.print(" and ");
					
					if (rotations != 4)	// rotated in some way (modulos works)
						System.out.print("rotated " + (rotations%4)*90 + " degrees");
					
					System.out.println(".");
				}		
			}
			patternNo++;
		}
		sc.close();
	}	
}
