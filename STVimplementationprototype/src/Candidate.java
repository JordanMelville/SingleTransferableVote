import java.util.ArrayList;

// This class has been designed to take into account all of the party data, these calculations are used in calculating the final seats
public class Candidate {


private String candidateName;
private ArrayList<Integer> totalVotes;

public Candidate(String name) {
	candidateName = name;
	totalVotes = new ArrayList<Integer>(); 
}


// formula for working out the threshold for winning a seat

public void addVote(Integer vote) {
	totalVotes.add(vote);
}

public String candidateName() {
	return candidateName;
}
}