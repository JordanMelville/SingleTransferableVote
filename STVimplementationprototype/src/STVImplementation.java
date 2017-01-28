
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
private int seats = 3;

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
public void LoadVotingData(String file) throws FileNotFoundException {
	Scanner sc;
	try{
		
		sc = new Scanner(new File(file));
		
		int totalCandidates = sc.nextInt();
		int totalVotes = sc.nextInt();
		sc.nextLine();
		
		System.out.println("The total number of candidates in the vote are as follows: " + totalCandidates);
		System.out.println("The total number of votes cast in the election are as follows : " + totalVotes);
		
		for(int i = 0; i < totalVotes; i++) {
			votes.add(i);
		}
		
		System.out.println("the quota calculated to win a seat in the first round is " + droopQuota());
		

		while(sc.hasNext()) {
			String candidateName = sc.next();
			int firstPreference = sc.nextInt();
			int secondPreference = sc.nextInt();
			Candidate newCandidate = new Candidate(candidateName, firstPreference, secondPreference);
			this.addCandidate(newCandidate);
			System.out.println("Candidates name: " + candidateName);
			System.out.println("First preference vote for the candidate " + firstPreference);
			System.out.println("Second preference vote for the candidate " + secondPreference);
		
		}
	
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
	} 
	}
}


