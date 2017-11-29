package algorithms;

public class Countingsort {
	int[] A = {2, 5, 3, 0, 2, 3, 0, 3, 8, 7, 9};
	
	public static void Cstest() {
		Countingsort tt = new Countingsort();
		int[] B = new int[tt.A.length];
		int maxnum = tt.A[0];
		for (int i = 1; i < tt.A.length; i++) {
			if (maxnum < tt.A[i]) {
				maxnum = tt.A[i];
			}
		}
		Countingsort.CountingSort(tt.A, B, maxnum);
		
		for (int n = 0; n < B.length; n++) {
			System.out.printf("%d ", B[n]);
		}
	}
	
	private static void CountingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];
		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;
		}
		
		for (int i = 1; i < C.length; i++) {
			C[i] = C[i] + C[i-1];
		}
		
		for (int n = B.length-1; n >= 0; n--) {
			B[C[A[n]]-1] = A[n];
			C[A[n]]--;
		}
	}
}
