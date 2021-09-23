import java.io.File;
import java.util.*;

public class Tester 
{
	public static void main(String[] args) throws Exception 
	{
		LZW compressor = new LZW ();
		
		long startTime = System.currentTimeMillis();
		//compressor.convertToBinary("writing.txt");
		compressor.decompress();
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total milliseconds for moveToBack is " + totalTime);
	}
}
