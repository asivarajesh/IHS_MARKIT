import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Palindrome
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter input string:");
		String input=sc.nextLine();
		sc.close();
		GeneratePalindromes(input);
	}
	//Method to Generate All Palindrome Substrings from a Given Input String
	public static void GeneratePalindromes(String instr)
	{
		String boundedstring = "@" + instr + "#";
		char charArray[] = boundedstring.toCharArray();
		int plengths[][] = new int[2][instr.length() + 1];
		int max;
		TreeMap<String,Integer> tmap = new TreeMap<String,Integer>((o1,o2)->o1.length()>=o2.length()?-1:1);

		for (int j = 0; j <= 1; j++) {
			plengths[j][0] = max = 0;
			int i = 1;
			while (i <= instr.length()) {
				while (charArray[i - max - 1] == charArray[i + j + max])
					max++;
				plengths[j][i] = max;
				int k = 1;
				while ((plengths[j][i - k] != max - k) && (k < max)) {
					plengths[j][i + k] = Math.min(plengths[j][i - k], max - k);
					k++;
				}
				max = Math.max(max - k, 0);
				i += k;
			}
		}

		for (int i = 1; i <= instr.length(); i++) {
			for (int j = 0; j <= 1; j++) {
				for (max = plengths[j][i]; max > 0; max--) {
					tmap.put(instr.substring(i - max - 1, max + j + i - 1),i - max - 1);
					}
				}
			}
		FilterPalindromes(tmap);
	}
	//Method to filter AllPalindrome Strings	
	public static void FilterPalindromes(TreeMap<String,Integer> tmap)
	{
		HashMap<String,Integer> tempMap=new HashMap<String,Integer>(tmap);
		ArrayList<String> alist =new ArrayList<String>(tmap.keySet());
		alist.sort((o1,o2)->o1.length()>=o2.length()?-1:1);
		
		for(int i=0;i<alist.size()-1;i++)
		{
			for(int j=i+1;j<alist.size();j++)
			{
				String temp = alist.get(j);
				if(alist.get(i).contains(temp))
				{
					alist.remove(temp);
				}
			}
		}
		for(String s:alist)
		{
			System.out.println(s+","+tempMap.get(s)+","+s.length());
		}
	}
}


























