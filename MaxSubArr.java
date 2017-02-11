import java.util.Scanner;

public class MaxSubArr {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int T = 2; //input.nextInt(); 
        int[][] cases = {{1, 2, 3, 4}, {2, -1, 2, 3,4, -5}}; //new int[T][];
//        for (int i = 0; i < T; i++) {
//        	int N = input.nextInt();
//        	cases[i] = new int[N];
//        	for (int j = 0; j < N; j++)
//        		cases[i][j] = input.nextInt();
//        }
        
        for (int i = 0; i < T; i++) {
 //       	System.out.print(i + "i ");
        	int[] sum = new int[cases[i].length];
        	sum[0] = cases[i][0];
        	int max = sum[0];
        	for (int j = 1; j < sum.length; j++) {
        		sum[j] = Math.max(sum[j - 1] + cases[i][j], cases[i][j]);
        		max = Math.max(max, sum[j]);
        	}
        	System.out.println(max);
        }

//        2
//        4
//        1 2 3 4
//        6
//        2 -1 2 3 4 -5
//        printArr(cases);
	}

	
	static void printArr(int[][]a) {

		System.out.print("   ");
		for (int j = 0; j < a[0].length; j++) {
			System.out.printf("%5d", j);
		}
		System.out.println();
		for (int j = 0; j <= a[0].length; j++) {
			System.out.print("-----");
		}
		System.out.println();

		
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + "| ");
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%5d", a[i][j]);
			}
			System.out.println();
		}
	}
}
