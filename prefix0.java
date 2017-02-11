import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prefix0 {
	static ArrayList<String> primitives = new ArrayList<String>();
	static String sequence = "";
	static int[] memoi;
	static int currentPos = 0;
	static int maxCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("prefix3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		String str = f.readLine();
		StringTokenizer st = new StringTokenizer(str);
		long start = System.currentTimeMillis();

		while (!str.equals(".")) {
			while (st.hasMoreTokens())
				primitives.add(st.nextToken());
			str = f.readLine();
			st = new StringTokenizer(str);
		}
		
		char[][]prims = new char[primitives.size()][];;
		
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			sequence = sequence.concat(st.nextToken());
		}
		memoi = new int[sequence.length()];
		int maxPrim = 0;
		for (String s: primitives)
			if (s.length() > maxPrim) maxPrim = s.length();
		
//		for (String s: primitives) System.out.print(s + "   ");
//		System.out.println();
//		System.out.println("maxPrim"+maxPrim);

//		System.out.println("0123456789");
//		System.out.println(sequence);
//		System.out.println(sequence.length());
		
		memoi[0] = 1;
		int result = 0, bestResult = 0;
		int gap = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (gap > maxPrim) {
//				System.out.println("break");
				break;
			}
			if (memoi[i] == 1) { // mark as 1 - "can get there"
				result = i;
				gap = 0;
				for (String pre: primitives) {
					int endIndex = (sequence.length() > (pre.length() + i)) ? (pre.length() + i) : sequence.length();
					String temp = sequence.substring(i, endIndex);
					if (temp.startsWith(pre)) {
						if ((i + pre.length()) < sequence.length())
							memoi[i + pre.length()] = 1;
						result = Math.max(result, i + pre.length());
					}
				}
				bestResult = Math.max(bestResult, result);
			} else gap++;
		}
		System.out.println(bestResult);
		
//		for (int i: memoi) System.out.print(i + "   ");
//		System.out.println();

		System.out.println(System.currentTimeMillis() - start);
		f.close();
		out.close();
	}
	
	static void printArr(int[][]a) {

		System.out.print("      ");
		for (int j = 0; j < a[0].length; j++) {
			System.out.printf("%5d", j);
		}
		System.out.println();
		for (int j = 0; j <= a[0].length; j++) {
			System.out.print("-----");
		}
		System.out.println();

		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%4s| ", primitives.get(i));
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%5d", a[i][j]);
			}
			System.out.println();
		}
	}
}
