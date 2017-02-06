
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// implementation of STV using example wikipedia data

public class STVImplementation {
	
private ArrayList<Candidate> candidateNames = new ArrayList<Candidate>();
private ArrayList<Integer> votes = new ArrayList<Integer>();
private ArrayList<Integer> secondPreferences = new ArrayList<Integer>();
private ArrayList<Integer> orange = new ArrayList<Integer>();
private ArrayList<Integer> pear = new ArrayList<Integer>();
private ArrayList<Integer> chocolate = new ArrayList<Integer>();
private ArrayList<Integer> strawberries = new ArrayList<Integer>();
private ArrayList<Integer> sweets = new ArrayList<Integer>();

private int seats = 3;
HashMap<String, Integer> candidateData = new HashMap<String, Integer>();

public void addCandidate(Candidate candidate) {
	candidateNames.add(candidate);
}

public void addVote(Integer vote) {
	votes.add(vote);
}
public static void main(String[] args) throws IOException{
	STVImplementation stv = new STVImplementation();
	BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
	
	while(true) {
		String input = "";
		
		input = breader.readLine();
		
		if(input.equals("finished")){
			break;
		}
		if(input.equals("Load")){
			stv.LoadVotingData("testingData.txt");
			break;
		}
		
	}

	}

// quota for working out the votes needed to be elected.
public int droopQuota() {
	return votes.size()/(seats + 1) + 1;
}

// load in data and create party data to be then used for calculating seats

// here i list a number of issues i need to fix
// 1. get the vote reader working. vote reader works fine - uses static arraylists at the moment(bad)
// 2. get the quota working with votes read in. - quota works fine at the moment
// 3. Make sure round 1 of the system works properly.
// 4. get a highest and lowest quota function to work out who is eliminated at the end of a round
// 5. Properly calculate full rounds of the wikipedia game
// 6. Adapt to work for all inputs

public void LoadVotingData(String file) throws FileNotFoundException {
	Scanner sc;
	int voteCounter = 0;

	
	try{
		
		sc = new Scanner(new File(file));
		
	
		while(sc.hasNext()) {
			String vote = sc.next();
			if (vote.length() > 1){
				char[] preferences = vote.toCharArray();
				int firstPreference = Character.getNumericValue(preferences[0]);
				System.out.println("first preference " + firstPreference);
				int secondPreference = Character.getNumericValue(preferences[1]);
				System.out.println("second preference " + secondPreference);
				System.out.println("");
				voteCounter++;
				if(firstPreference == 1) {
					orange.add(firstPreference);
				}
				if(firstPreference == 2) {
					pear.add(firstPreference);
				}
				if(firstPreference == 3) {
					chocolate.add(firstPreference);
				}
				if(firstPreference == 4) {
					strawberries.add(firstPreference);
				}
				if(firstPreference == 5) {
					sweets.add(firstPreference);
				}
				votes.add(firstPreference);
				secondPreferences.add(secondPreference);
				
			}
			// if the input does not contain more than 1 preference we then 
			else {
				char[] noprefs = vote.toCharArray();
				int originalVote = Character.getNumericValue(noprefs[0]);
				System.out.println("first preference " + originalVote);
				System.out.println("");
				voteCounter++;
                if(originalVote == 1) {
					orange.add(originalVote);
				}
				if(originalVote == 2) {
					pear.add(originalVote);
				}
				if(originalVote == 3) {
					chocolate.add(originalVote);
					
				}
				if(originalVote == 4) {
					strawberries.add(originalVote);
				}
				if(originalVote == 5) {
					sweets.add(originalVote);
				}
				votes.add(originalVote);
				
			}
			
		}
		System.out.println("The droop quota is as follows " + droopQuota());
		System.out.println("The number of votes conducted for oranges: " + orange.size());
		System.out.println("The number of votes conducted for pears: " + pear.size());
		System.out.println("The number of votes conducted for chocolate: " + chocolate.size());
		System.out.println("The number of votes conducted for strawberries: " + strawberries.size());
		System.out.println("The number of votes conducted for sweets: " + sweets.size());
		
		
		if(orange.size() > droopQuota()) {
			System.out.println("Orange has been elected in round 1");
		}
		else {
			System.out.println("Orange has not met the quota.");
		}
		if(pear.size() > droopQuota()) {
			System.out.println("Pear has been elected in round 1");
		}
		else {
			System.out.println("Pear has not met the quota.");
		}
		if(chocolate.size() > droopQuota()) {
			System.out.println("Chocolate has been elected in round 1");	
		}
		else {
			System.out.println("Chocolate has not met the quota.");
		}
		if(strawberries.size() > droopQuota()) {
			System.out.println("Strawberries has been elected in round 1");
		} else
		{
			System.out.println("Strawberries has not met the quota. ");
		}
		if(sweets.size() > droopQuota()) {
			System.out.println("Sweets has been elected in round 1");
		} else {
			System.out.println("Sweets has not met the quota");
		}
			
		
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
	} 
	}
}


