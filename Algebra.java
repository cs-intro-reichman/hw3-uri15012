// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println("times fund:");
		System.out.println(times(3,4));
		
	}  
	public static int MyAbs(int x1) {
		
		int positive = 0;
		if (x1>=0){
		return x1;
		} 
		else {
			for (int i = x1;i < 0; i++){
				positive++;
			}
			return positive;
		
		}
		
	}
		
		

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
	if(x2 > 0)
	{		
		for (int i = 0;i < x2; i++){ // to run exaclty the number of times of b
			x1++; // adds 1 to a by the end of the loop a has been incremented b times
		}
		return x1;
	}
	else {
		if (x2 < 0)
		{
				for (int i = 0;i <MyAbs(x2) ; i++){ // to run exaclty the number of times of b
					x1--; // subtracts 1 to a by the end of the loop a has been decremented b times	
			}
			return x1;
		}
		return x1;
		}		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 > 0)
	{		
		for (int i = 0;i < x2; i++){ // to run exaclty the number of times of b
			x1--; // adds 1 to a by the end of the loop a has been incremented b times
		}
		return x1;
	}
	else {
		if (x2 < 0)
		{
				for (int i = 0;i <MyAbs(x2) ; i++){ // to run exaclty the number of times of b
					x1++; // adds 1 to a by the end of the loop a has been decremented b times	
			}
			return x1;
		}
		return x1;
		}		
	}

	// Returns x1 * x2
	public static int times(int x1, int x2){
		int temp = 0;
		if ((x1>0 && x2>0) || (x1<0 && x2<0)){ // se o numero for todo positivo ou todo negativo
			for (int i = 0; i < MyAbs(x2);i++){
				temp = plus(temp,MyAbs(x1));
			}
		}
			 else { // se um deles for negativo
				for (int i = 0; i<MyAbs(x2); i++){
					temp = minus(temp,MyAbs(x1));
				}
			
			}
			return temp;
		}
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 0;
		if (x==0)return 0;
		if (n==0)return 1;
		if (n==1)return x;
		if (x>0 || x<0 && mod (n, 2) == 0){
			if (x<0){
				x = MyAbs(x);
			}
			for (int i = 1; i<n;i++){
				pow = times (pow,x);
			}
		}else 
		{
			for (int i =1;i<n;i++){
				pow = times(pow,MyAbs (x));

			}
		}
		
	return pow;

}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2)
	{
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

		return remainder ;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		if (x < 0) {
			throw new ArithmeticException("Square root of negative numbers is not defined for integers.");
		}
		result = 0;
		while (times (result,result)<=x){
			result ++;
		}
		return minus (result,1);
	}
	
}	  	  
