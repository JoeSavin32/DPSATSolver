import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This material is based upon work supported by 
 * the National Science Foundation under Grant No. 1140753.
 * 
 */


/**
 * This class is a skeleton for a backtracking SAT solver
 * It may be used as a handout to explain backtracking and 
 * provide a starting point for students to build 
 * their respective backtracking solvers
 * 
 * @author Dr. Andrea Lobo
 * @author Dr. Ganesh R. Baliga 
 * 
 *
 */

//Test comment

public class dpsolver {
	
	// Students will define class Formula, possibly as 
	// a separate public class
	

	static Formula formula;

	 // Read the provided input formula
	static void readFormula ( String fileName ) {
		 ArrayList<Integer> equation = new ArrayList<Integer>();
	        int literals = 0;
            int finalClauses=0;
	        try {
	            int clauses = 1;
	            File inputFile = new File("/Users/Sav/Downloads/inputs/" + fileName
	                    + ".cnf");
	 
	            FileReader fileReader = new FileReader(inputFile);
	            Scanner scanner = new Scanner(fileReader);
	            String line = null;
	            boolean done = false;
	            while (!done && (line = scanner.nextLine()) != null) {
	                if (line.charAt(0) == 'p') {
	                    String[] pLine = new String[4];
	                    pLine = line.split(" ");
	                    literals = Integer.parseInt(pLine[2]);
	                    clauses = Integer.parseInt(pLine[3]);
	                    finalClauses=clauses;
	                } else if (!(line.charAt(0) == 'c')) {
	                    String[] variables;
	                    variables = line.split(" ");
	                    for (int i = 0; i < variables.length; i++) {
	                        equation.add(Integer.parseInt(variables[i]));
	                    }
	                    //subtracts number of clauses so this loop will not over execute
	                    clauses--;
	                }
	                if (clauses == 0) {
	                    //signifies that whole formula has been grabbed
	                    done = true;
	                }
	            }
	 
	        } catch (Exception ex) {
	            //If no file is found with given parameter, error prints out.
	            System.out.println("ERROR. File does not exist.");
	        }
		formula = new Formula(equation, finalClauses);
		
	}

	// Returns true if the formula has an empty clause, false otherwise
	boolean hasEmptyClause ( Formula f ) {
		// Stub
		return false;
	}
	
	// Returns true if the formula has no clauses left, false otherwise
	boolean isEmpty ( Formula f ) {
		// Stub
		return false;
		
	}
	
	// Return branch variable.
	int selectBranchVar ( Formula f ) {
		// Stub
		return 0;
	}
	
	// Set given variable to given true/false value
	// Variable value may be positive or negative
	void setVar ( int var, Formula f, boolean tf) {
		// Stub
		
	}
	
	// Set given variable to "unassigned" in the given formula
	void unset ( int var, Formula f) {
		// Stub
		
	}

	// Formula is satisfiable
	void success (Formula f) {
		// Stub		
		System.out.println ( "Formula is satisfiable");
		
		// Print satisfying assignment
			
	}
	
	// Formula is unsatisfiable
	void failure (Formula f) {
		// Stub		
		System.out.println ("Formula is unsatisfiable");
				
	}
	
 	public void solve ( String fileName ) {
 		
		readFormula ( fileName );
		
		if (dp ( formula ) )
			success ( formula );
		else
			failure ( formula );
		
	}
	
 	// Recursive backtracking solution
	boolean dp ( Formula formula ) {
		
		
		if (isEmpty(formula)) // First base case: solution found
			return true;
		else if (hasEmptyClause (formula)) // Second base case: dead end found
			return false;
		else {
			
			// Pick a branch variable
			int var = selectBranchVar ( formula );
			
			// Try to set var = true in the formula
			
			setVar ( var, formula, true );
			
			if (dp(formula)) 
				return true;
			else {
				
				// Unset var in the formula 
				unset ( var, formula );
				
				// Setting var to true did not work. 
				// Now try var = false
				
				setVar ( var, formula, false );
				
				if (dp (formula))
					return true;
				else {
					// Neither true nor false worked, so unset the branch 
					// variable and head back
					unset ( var, formula );
					return false;			
				}
			}
		}	
	}
	

	public static void main(String[] args) throws IOException {
		
//		if (args.length < 1) {
//			System.err.println ("Usage: java dpsolver_skeleton cnf-formula");
//			System.exit(0);
//		}
		
		// Insert timing code here...
//		new dpsolver().solve ( args[0] );
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
	            System.in));
		
		String input = " ";
		while (!(input.equals(""))) {
            System.out.println("Enter file name: ");
            input = stdin.readLine();
            if(!(input.equals(""))){
 //           long start = System.currentTimeMillis();
            readFormula(input);
 //           long end = System.currentTimeMillis();
//            System.out.println("Time: " + (end - start) + " milliseconds");
            }
        }

	}

}