import java.util.*;
import java.io.*;

public class LZW{
	final int NUM=9;
	public LZW()
	{
		
	}
	public void writeToFile(String file,String str) throws Exception{
		try(FileOutputStream os=new FileOutputStream(file)){
			os.write(this.convertToBinary(file));
		}
	}
	
	public int convertToBinary(String file) throws Exception
	{
		StringBuilder ret = new StringBuilder("");
		ArrayList<String> dict = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		for(int i =0;i<=255;i++)
		{
			dict.add(""+(char)i);
		}
		String current = ""+((char)(reader.read()));
		String next = ""+((char)(reader.read()));
		while(reader.ready())
		{
			if(!dict.contains(current+next)&&dict.size()<512)
			{
				dict.add(current+next);
				current +=next;
			}
			else
			{
				current = next;  
			}
			next = ""+((char)(reader.read()));
		}

		throw new Exception("During the first assignment, Zach did not finish his encoder method called 'Convert to Binary'. When Ben took over Zach's code, he made a decoder method using his own encoder method, but did not touch Zach's encoder method. When I took over this code, the encoder method only forms the dictionary, but fails to produce an encoded file.");
	}

	public String decompress(ArrayList<Integer> compressed)
	{
		Map<Integer, String> dictionary = new HashMap<Integer, String>();
		
		int dictionarySize = 256;
		
		for (int i = 0; i < dictionarySize; i++)
		{
			Character theChar = (char)i;
			String theString = "" + theChar;
			dictionary.put(i, theString);
		}
		
		int firstCompressedInt = compressed.get(0);
		Character firstCompressedChar = (char)firstCompressedInt;
		
		compressed.remove(0);

		String currentLetters = "" + firstCompressedChar;
		
		String output = currentLetters;
		
		for (int i = 0; i < compressed.size(); i++)
		{
			int letters = compressed.get(i);
					
			String dictionaryEntry;

			if (dictionary.containsKey(letters))
			{
				dictionaryEntry = dictionary.get(letters);
			}
			else
			{
				dictionaryEntry = currentLetters + currentLetters.charAt(0);
			}
			
			output = output + dictionaryEntry;
			
			dictionary.put(dictionarySize++, currentLetters + dictionaryEntry.charAt(0));
			
			currentLetters = dictionaryEntry;
		}
		
		return (output);
		
		/*
		ArrayList<String> dict=new ArrayList<String>();
		for (int i=0;i<256;i++){
			dict.add(""+(char)i);
		}
		
		String prev=""+(char)(Integer.parseInt(compressed.substring(0,NUM),2)),decompressed=prev;
		int c=0;
		while(compressed.length()>NUM){
			c=Integer.parseInt(compressed.substring(NUM,2*NUM),2);
			System.out.print(c);
			if(c<dict.size()){
				dict.add(prev+dict.get(c).charAt(0));
				decompressed+=dict.get(c);
			}
			else{
				dict.add(prev+prev.charAt(0));
				decompressed+=prev+prev.charAt(0);
			}
			prev=dict.get(c);
			compressed=compressed.substring(NUM);
		}
		
		return(decompressed);
		*/
	}
	/**
	 * writeToFile() and decompress() methods are working. I haven't touched the 
	 * convertToBinary() method since I forked initially. 
	 */
}

