/**
 *  This class creates and manages one array of pegs from the game MasterMind.
 *
 *  @author Mayank Singamreddy
 *  @since 9 October 2017
*/

public class PegArray {

	// array of pegs
	private Peg [] pegs;

	// the number of exact and partial matches for this array
	// as matched against the master.
	// Precondition: these values are valid after getExactMatches() and getPartialMatches()
	//				are called
	private int exactMatches, partialMatches;
		
	/**
	 *	Constructor
	 *	@param numPegs	number of pegs in the array
	 */
	public PegArray(int numPegs) {
		pegs = new Peg[numPegs];
		for (int i = 0; i < numPegs; i++) {
			pegs[i] = new Peg();
		}
	}
	
	/**
	 *	Return the peg object
	 *	@param n	The peg index into the array
	 *	@return		the peg object
	 */
	public Peg getPeg(int n) { return pegs[n]; }
	
	/**
	 *  Finds exact matches between master (key) peg array and this peg array
	 *	Postcondition: field exactMatches contains the matches with the master
	 *  @param master	The master (code) peg array
	 *	@return			The number of exact matches
	 */
	public int getExactMatches(PegArray master)
	{ 
		int count = 0;
		for(int i = 0; i < pegs.length; i++)
			if(pegs[i].getLetter() == master.pegs[i].getLetter())
				count++;
		exactMatches = count;
		return count;
	}
	
	/**
	 *  Find partial matches between master (key) peg array and this peg array
	 *	Postcondition: field partialMatches contains the matches with the master
	 *  @param master	The master (code) peg array
	 *	@return			The number of partial matches
	 */
	public int getPartialMatches(PegArray master) 
	{ 
		boolean[] isfound = new boolean[pegs.length];
		int count = 0;
		for(int i = 0; i < pegs.length; i++)
			for(int a = 0; a < pegs.length; a++)
			{
				if(master.pegs[i].getLetter() != pegs[i].getLetter() && master.pegs[i].getLetter() == pegs[a].getLetter() && !isfound[a])
				{
					count++;
					isfound[a] = true;
					a = pegs.length;
				}
			}
		partialMatches = count;
		return count;
	}
	
	// Accessor methods
	// Precondition: getExactMatches() and getPartialMatches() must be called first
	public int getExact() { return exactMatches; }
	public int getPartial() { return partialMatches; }

}