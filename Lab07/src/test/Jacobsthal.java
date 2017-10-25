package test;
import java.util.ArrayList;
import java.util.Arrays;

public class Jacobsthal {

	public static void main(String[] args) {
		//call Jacobsthal_recurive method
		long startTime = System.nanoTime();
		System.out.print("Recursive version: ");
		for(int i=0; i< 9; i++) {
			System.out.print(Jacobsthal_recursive(i) + ", ");
		}
		System.out.println(Jacobsthal_recursive(9) + "\n");
		long totalTime = (System.nanoTime() - startTime) / 1000;
		
		System.out.println("Time taken to execute recursive version: " + String.format("%.2f", (double)totalTime) + " msec" + "\n");
		
		//call Jacobsthal_iterative method
		long startTime1 = System.nanoTime();
		System.out.println(Jacobsthal_iterative(10));
		long totalTime1 = (System.nanoTime() - startTime1) / 1000;
		System.out.println();
		System.out.println("Time taken to execute iterative version: " + String.format("%.2f", (double)totalTime1) + " msec");
		
		//call overflowCheck method
		System.out.println();
		System.out.println("Max f(x) is " + OverflowCheck() + "\n");
		System.out.println("Argument x is " + OverflowCheckNumber());

	}
	public static String Jacobsthal_iterative(int n) {
		int firstNumber = 0;
        int secondNumber = 1;
                 
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int nextNumber;
         
        list.add(firstNumber);
        list.add(secondNumber);
         
        for(int i = 1; i <= n - 2; i++) { 
            
            nextNumber = secondNumber + 2 * firstNumber;
            list.add(nextNumber);
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        String s = Arrays.toString(list.toArray());
        s = s.substring(1,s.length()-1);
        return "Iterative version: " + s;
	}
	
	public static long Jacobsthal_it(int n) {
		long first = 0;
		long second = 1;
		long next = 1;
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			for(int i = 0; i<=n-2; i++) {
				next = second + 2*first;
				first = second;
				second = next;
			}
		}return next;
	}
	
	public static long Jacobsthal_recursive(int n){

	    long temp_result;
	    if(n==0) 
	        return 0;

	    else if(n==1) 
	        return 1; 

	    else if(n>1) {
	        temp_result = Jacobsthal_recursive(n-1)+2*Jacobsthal_recursive(n-2);

	        return (temp_result);
	    }
	    else
	        return -1;
	}
	
	
	public static long OverflowCheck(){
		int n = 0;
		long result = Jacobsthal_it(n);
		while(result >= 0) {
			n++;
			result = Jacobsthal_it(n);
		}
		return Jacobsthal_it(n-1);
	}
	
	public static long OverflowCheckNumber(){
		int n = 0;
		long result = Jacobsthal_it(n);
		while(result >= 0) {
			n++;
			result = Jacobsthal_it(n);
		}
		return n;
	}


}
