import java.io.File;
import java.util.*;

public class Tester 
{
	public static void main(String[] args) throws Exception 
	{
		LZW compressor = new LZW ();
		String string = "1100001110001011000111000000001000000101000000011000000111000001101000001011000010001000001001000010101000001111100011";
		
		
		long startTime = System.currentTimeMillis();
		compressor.decompress("lzw-file3.txt");
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total milliseconds for moveToBack is " + totalTime);
	}
}
