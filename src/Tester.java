import java.io.File;
import java.util.*;

public class Tester 
{
	public static void main(String[] args) throws Exception 
	{
		LZW compressor = new LZW ();
		int [] list = {97, 98, 99, 256, 258, 257, 259, 262, 261, 264, 260, 266, 263, 267, 265, 268, 271, 270, 273, 269, 275, 272, 276, 274, 277, 280, 279, 282, 278, 284, 281, 285, 283, 286, 289, 288, 283, 100, 101, 102, 103, 290, 287, 298, 297, 300, 291, 99, 293, 295, 301, 299, 302, 306, 309, 308, 311, 307, 313, 310, 314, 312, 315, 318, 317, 320, 316, 322, 319, 323, 321, 324, 327, 326, 329, 325, 331, 328, 99};
	    ArrayList <Integer> list2 = new ArrayList<Integer>();
	    
	    for(Integer num:list)
	    {
	         list2.add(num);
	    }
		
		long startTime = System.currentTimeMillis();
		compressor.decompress(list2);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total milliseconds for moveToBack is " + totalTime);
	}
}
