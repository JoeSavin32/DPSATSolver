import java.util.ArrayList;


public class Formula {

	ArrayList<Integer> formula;
	ArrayList<Boolean > formulaVals = new ArrayList<Boolean>();
	int totalClauses = 0;
	int currClauses = 0;
	
	public Formula(ArrayList<Integer> inFormula, int inClauses){
		formula=inFormula;
		for(int i=0; i<formula.size(); i++){
			formulaVals.add(true);
		}
		totalClauses = currClauses = inClauses;
	}
	
	private void removeVariable(int varPos)
	{
		formulaVals.remove(varPos);
		formulaVals.add(varPos, false);
	}
	
	
	private void removeClause(int varPos)
	{
		boolean stop = false;
		int curPos = varPos;
		for(; !stop && curPos>=0; curPos--)
		{
			if(formula.get(curPos)==0)
			{
				stop=true;
			}
		}
		stop = true;
		if(curPos!=0){
			curPos++;
		}
		for(; !stop && curPos< formula.size(); curPos++)
		{
			formulaVals.remove(curPos);
			formulaVals.add(curPos, false);
			if(formula.get(curPos)==0){
				stop = true;
			}
		}
		currClauses--;
	}
	
	private boolean isEmpty()
	{
		for(int i=0; i<formulaVals.size(); i++){
			if (formulaVals.get(i)==true){
				return false;
			}
		}
		return true;
	}
	
	
	private boolean hasEmptyClause()
	{
		if(totalClauses!=currClauses){
			return true;
		}
		else
		return false;
	}
	
	
}
