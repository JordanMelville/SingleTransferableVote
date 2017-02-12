import java.util.*;
import java.io.*;


public class stv{

 public static int numberOfCandidates = 5; 
 public static int numberOfSeats = 3; //Should equal numcand if we want to produce ordered list of all candidates
public static int round = 0;
public static int quota = 0;

 public static void main(String[] args){
	 
	 boolean beenElected = false;
     
  // An arraylist of integer arrays to be used in reading in from file.
     ArrayList<int[]> fileData =new ArrayList<int[]>();
     
     ReadArrayListOfIntArrays("testdata.txt", fileData);

     
     int totalVotes = fileData.size();

     int[][] votes = new int[totalVotes][];
     
     for(int n = 0; n < totalVotes; n++){
	 votes[n] = (int[]) fileData.get(n);

	 for(int k = 0; k < votes[n].length; k++){
	     votes[n][k]--; 
	     System.out.print(votes[n][k]  + " ");
	 }
	 System.out.println();
     }
     
     quota = totalVotes / (numberOfSeats + 1) + 1;
     
     System.out.println("The vote quota needed for a candidate to be elected is " + quota);
     System.out.println();
     
     // an array to return the list of winners.
     int[] winner = new int[numberOfSeats];
     // an array to deal with left over votes after a candidate is elected
     int[] surplusVotes = new int[numberOfSeats];
     // an array to deal with lowest candidates votes being redistributed
     int[] eliminatedVotes = new int[numberOfSeats];
     // holds the total number of votes for each candidate.
     int[] candidateVotes = new int[numberOfSeats];
     
     
     // boolean arrays to check to see if a candidates number has been elected and if so removed.
     boolean[] elected = new boolean[numberOfCandidates];
     boolean[] removed = new boolean[numberOfCandidates];
    

     for(int i = 0; i < totalVotes; i++) {
	 candidateVotes[votes[i][0]]++;
     }
    
     
     for(int i = 0; i < numberOfCandidates; i++)
	 System.out.println("votes of " + i + ": " + candidateVotes[i]);
     
    
     
     System.out.println("The current round is " + round);
     
     for(int i = 0; i < numberOfCandidates; i++) {
    	 
    	 if(candidateVotes[i] >= quota){
    		 beenElected = true;
    		 System.out.println("Candidate: " + i + " has been elected ");
    		 System.out.println();
    		 winner[i] = i;
    		 surplusVotes[i] = candidateVotes[i] - quota;
	 }     
	 }

  
     for(int i = 0; i < numberOfCandidates; i++) {
    	 // only print out surplus votes if the surplus votes
    	 if(surplusVotes[i] > 0) {
	 System.out.println("surplus of " + i + ": " + surplusVotes[i]);
    	 }
     }
     System.out.println();
    
   

     if(beenElected){//transfer votes of elected
	 for(int n = 0; n < numberOfCandidates; n++)
	     if(elected[n] && !removed[n]){
	     
	    	 
	    	 
	    	 
	    	 
	     // decrement while loop counter and add the candidate to the winners array
	    // remove the candidate from being in the running, set the boolean value back to false
	   // increase round and loop back to the beginning.
	     numberOfSeats--;	 
	     winner[n]	= n; 
		 removed[n] = true;
		 beenElected = false;
		 round++;
		 System.out.println(n + " has been removed from the list of candidates");
	     }
     }
     else{//nobody elected, eliminate lowest candidate
    	 int lowestVotes = Integer.MAX_VALUE;
    	 int lowestPosition = 0;
    	for(int i = 0; i < numberOfCandidates; i++) {
    		if(candidateVotes[i] < lowestVotes) {
    			lowestVotes = candidateVotes[i];
    			lowestPosition = i;
    		}
    	removed[lowestPosition] = true;
    	eliminatedVotes[lowestPosition] = candidateVotes[lowestPosition];
    	
    	System.out.println(lowestPosition + " has been removed from the list of candidates");
    	}
     }
     
 }//END main

/*****************************************************************/

 public static void ReadArrayListOfIntArrays(String FileName, ArrayList<int[]> A){

     try{
	 FileInputStream fstream = new FileInputStream(FileName);

	 // Get the object of DataInputStream
	 DataInputStream in = new DataInputStream(fstream);
	 BufferedReader br = new BufferedReader(new InputStreamReader(in));

	 String strLine;

	 //Read file line by line
	 while ((strLine = br.readLine()) != null){
	     String line[] = strLine.split(" ");
	     int[] arr = new int[line.length];
	     for(int k = 0; k < line.length; k++)
		 arr[k] = Integer.parseInt(line[k]);
	     A.add(arr);
	 }

	 //Close the input stream
	 in.close();
     }catch (Exception e){//Catch exception if any
	 System.err.println("Error: " + e.getMessage());
     }
 }

/*****************************************************************/
}

