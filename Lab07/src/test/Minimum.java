package test;

public class Minimum {
	public static int minimum(int A[], int size) {
		if(size == 1) {
			return A[0];
		}
		int min = minimum(A, size-1);
		if(A[size-1] < min) {
			return A[size-1];
		}
		else 
			return min;
	}
	
	public static void main(String args[]) {
		int A[] = {10, -20, 1, 2, 0, 5, 100};
		
		int s = minimum(A, A.length);
		System.out.println(s);
	}

}

