// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan; // start with the initial amount of loan
		rate = rate /100;
	for (int i = 0; i < n; i++) { // n foi dado 
		balance = (balance-payment)*(1+rate);// o loop do for ja faz o elevado da formula 
	}
		return balance; // calculei oque sobra no final
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { // computes the periodic payment that fully repays a loan after n periods 
		// the goal is to find the smallest periodic payment (g) that results in the loan's ending balance being close to 0.
		//it takes the epsilon the small increment used to adjust the payment
		iterationCounter = 0; // is used to track the number of iteractions . whether or not you need to include it depends on the requirements of your program. 
		//here it is required, tracking the iteractions helps determine whether the method is efficient.
    
        double payment = loan / n;// this ensures the ending balance will initially be positive it is a safe starting point. the brute force method uses an iterative
		//trial and error approach to approximate solution.it tests potecial solution until it finds one that works.
    
        double increment = epsilon; // ensures that we gradually increase the payment until the ending balance becomes zero
    
        while (true) { // the condition true in while is a constant logical expression that is always true this
		// creates an infinite loop because the condition will never evaluate it to false unless you break out of the loop
            double balance = endBalance(loan, rate, n, payment); // it works trying difeerent values of payment and observing the result balance 
    
            if (balance <= 0) { // if the calculated balance is less than or equal to 0 it means the payment is sufficient to fully repay the loan 
                break; 
            }
    
            
            payment = payment + increment;
    
            
            iterationCounter++;
        }
    
        
        return payment; // once the loop is exited when the balance <=0 the function returns the final value of payment
    }

	
   
    
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
        double lo = loan / n; // start with a guess that is too small to cover interest we don't count for the interesting yet
        double hi = loan; // high payment that overpays the loan resulting in a negative balance it is higher than what is needed to pay leaving a negative balance 
		// the negative result comes from evaluating the ending balance (endbalance), not hi itself.
        double mid;

        while (hi - lo > epsilon) { // we use while because we don't know till when is going to iterate, 
		// it ensures it's going to narrowing down until the interval becomes smaller than the desired precision (epsilon) 
            mid = (lo + hi) / 2;
            double balance = endBalance(loan, rate, n, mid);
            if (balance > epsilon) { // positive balance says that the current payment is too low and it hasn't paid off the entire loan 
                lo = mid; // it eliminates half of the serach range where the solution cannot exist and it means that the lo is small it has to be bigger you need to pay more 
            } else if (balance < -epsilon) { // ensure that it is negative with the - before the negative 
                hi = mid;
            } else { // that means that it's close enough to zero it is already a good enough solution 
                return mid;
            }
            iterationCounter++;
        }
        return (lo + hi) / 2;
    }
}

		
		// the brute force is a trial an error solution approach that systematically tests possible solutions 
		// disadvantages of the bruteforce is that it takes many iteractions to converge especially if the solution is far from the starting point 
		// smaller epsilon gives more accurate results but increases the number of iteractions sinificantly

		// bisection - start with two initial bounds L, low guess and H high guess. L f(L)>0 when payment is too low, balance is positive
		// f(H)<0 payment is too high balance is negative . g is calculated as the midpoint of the current bounds (L+H)/2 
		// g it is the current guess for the correct value of the periodic payment that will make the loan ending balance f(g) = 0.
		// the g lies like if f(g)>0 is too low, f(g)<0 is too high and f(g)≈0 is the correct payment 
		// each iteraction the range L,H shrinks and g becomes more accurate estimate of the correct payment 
		
		
		
		
		
		
		