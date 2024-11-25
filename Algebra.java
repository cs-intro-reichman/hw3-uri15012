// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0;i < x2; i++){ // to run exaclty the number of times of b
			x1++; // adds 1 to a by the end of the loop a has been incremented b times
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i<x2; i--){ 
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = x1; // I start with the first value and add x2-1 because I started with the first 
		for (int i = 0; i<x2-1; i++){
			result = result + x1;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x1, int x2) {
		int result = 1;// remember not starting with 0 because multiplication for 1 doesn't change
		for (int i = 0; i<x2;i++){ // it will hapen be times because the i=0
			result = times(result,x1);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2==0) {
			throw new ArithmeticException("Division by zero not allowed");
		}
		int result = 0;
		while (x1>=x2){
			x1 = minus(x1,x2);
			result ++;
		}
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2==0) {
			throw new ArithmeticException("Division by zero not allowed");
		}
		int quotient = div(x1,x2); // get the integer 
		int remainder = minus(x1,times(x2,quotient)); // x1-(quotient*b)

		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) {
			throw new ArithmeticException("Square root of negative numbers is not defined for integers.");
		}
		int i = 1;
		while (pow(i,2)<=x){
			i++;
		}
		return i=1;
	}	  	  
}